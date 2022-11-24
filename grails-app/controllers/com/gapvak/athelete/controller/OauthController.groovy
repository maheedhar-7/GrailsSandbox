package com.gapvak.athelete.controller

import com.gapvak.athlete.domain.Activity
import com.gapvak.athlete.domain.Athlete
import com.gapvak.athlete.domain.Login
import com.gapvak.athlete.service.ActivityService
import com.gapvak.athlete.service.AthleteService
import grails.converters.JSON
import groovyx.net.http.HTTPBuilder
import  groovyx.net.http.ContentType
import groovyx.net.http.Method
import groovyx.net.http.URIBuilder

class OauthController {

    AthleteService athleteService
    ActivityService activityService

    def authorize() {
        log.info("the logger statement in the authorize")
    def stravaConfig =  grailsApplication.config.oauth.providers.strava
//        session.authorize = true
        String authorizationUrl = stravaConfig.authorizationUrl
        URIBuilder uriBuilder = new URIBuilder(authorizationUrl)
        uriBuilder.addQueryParam('client_id', stravaConfig.client_id)
        uriBuilder.addQueryParam('redirect_uri', stravaConfig.callbackUrl)
        uriBuilder.addQueryParam('response_type', 'code')
        uriBuilder.addQueryParam('approval_prompt', 'auto')
        uriBuilder.addQueryParam('scope', stravaConfig.scope)
        String authUrl = uriBuilder.toString()
        println "Redirecting to Authorization URL: ${authUrl}"
        log.info("Redirecting to Authorization URL: ${authUrl}")

        redirect url: authUrl
//        render("Hello World")
    }



    def callback() {
        println ("params code in callback ${params.code}")
        String authorizationCode = params.code
        if(!authorizationCode) {
            println "Authorization code is not available."
            redirect url : 'http://localhost:8080/GrailsSandbox/'
            return
        }
        def tokenData = this.getAccessToken(authorizationCode)
        println "token data is ${tokenData}"
        println "firstname is tokendata is ${tokenData.athlete.firstname}"

//        println "tokendata.access_token is ${tokenData.access_token}"
//        def stravaAthlete = getStravaAthlete(tokenData.access_token)
//        println "stravaAthlete in callback is ${stravaAthlete as grails.converters.JSON}"

        // check if athlete exists with strava username.
        Athlete athlete = athleteService.findByUsername(tokenData.athlete.username)
        println "user name in callback is ${tokenData.athlete.username}"

        if(!athlete) {
            athlete = new Athlete()
            // set the properties from stravaAthlete
            athlete.firstName = tokenData.athlete.firstname
            athlete.lastName = tokenData.athlete.lastname
            athlete.userName = tokenData.athlete.username
            athlete.accessToken = tokenData.access_token
            athlete.refreshToken = tokenData.refresh_token
            athlete.expiresAt = tokenData.expires_at
            athlete.password = "maheedhar"
            athlete.email = "hushly@gmail.com"
            athlete.phoneNumber = "12345678910"
            athleteService.save(athlete)
        } else {
            athlete.accessToken = tokenData.access_token
            athlete.refreshToken = tokenData.refresh_token
            athlete.expiresAt = tokenData.expires_at
            athleteService.save(athlete)
        }
//        // log the athlete in by setting the sesion attribute
        session.athlete = athlete
        println "session in call back after setting athlete is ${session.athlete as grails.converters.JSON} ${session.athlete.id}"
//
//
//        // sync the activities from the strava to the app.
        athleteService.syncAthleteAndActivities()
//
//        // redirect to the index page.
        redirect controller: "athlete", action: "index"
    }

//    private getStravaAthlete(String accessToken) {
//        Athlete athlete = athleteService.findByAccessToken(accessToken)
//        athlete
//    }


    private getAccessToken(String authorizationCode) {
        def tokenObj
        println "coming into getaccesstoken ${authorizationCode}"
        def stravaConfig =  grailsApplication.config.oauth.providers.strava
        def http = new HTTPBuilder(stravaConfig.tokenUrl)
//        def resp = strava.post() {
//            body = [
//                code: authorizationCode,
//                client_id: stravaConfig.client_id,
//                client_secret: stravaConfig.secret,
//                redirect_uri: stravaConfig.callbackUrl,
//                grant_type: "authorization_code"
//            ]
//        }
        http.request(Method.POST) { req ->
            requestContentType = "application/x-www-form-urlencoded"
            body = [
                    code: authorizationCode,
                    client_id: stravaConfig.client_id,
                    client_secret: stravaConfig.client_secret,
                    grant_type: "authorization_code"
            ]
            response.success = { resp, json ->
                tokenObj = json
                println "json in accesstoken is ${json}"
            }
        }
        println "tokenObj in acess token is ${tokenObj}"
        tokenObj
    }


    def loginAuthorization() {
        def authorizationUrl = grailsApplication.config.oauth.providers.strava.userLoginAuthorizationCodeUrl
        print "authorization url is ${authorizationUrl}"
        redirect(url: authorizationUrl, action: "userComputation")
    }








//    def checkAuthGetToken() {
//        def urlWithCode = request.getParameter("code")
//        def tokenUrl = grailsApplication.config.oauth.providers.strava.tokenUrl
//        def code = params.code
//        print "code is ${code}"
//        def client_id = grailsApplication.config.oauth.providers.strava.client_id
//        def clientSecret = grailsApplication.config.oauth.providers.strava.client_secret
//        def callBackURL = grailsApplication.config.oauth.providers.strava.callBackUrl
//        def http = new HTTPBuilder('http://localhost:8080/')
//        println "http is ${http}"
//        def jsonObj
//        http.request(Method.POST) { req ->
//            uri.path = tokenUrl
//            requestContentType = "application/x-www-form-urlencoded"
//            body = [
//                    code: code,
//                    client_id: client_id,
//                    client_secret: clientSecret,
//                    redirect_uri: callBackURL,
//                    grant_type: "authorization_code"
//            ]
//            response.success = { resp, json ->
//                jsonObj = json
//                params.setProperty("refresh_token", json.refresh_token)
//                params.setProperty("access_token", json.access_token)
//                params.setProperty("expires_at", json.expires_at)
////                params.setProperty("user_name", json.athlete[username])
//                println "access token is ${json}"
////                println "username in params is ${params.user_name}"
//            }
//        }
////        request.setAttribute("jsonObj", jsonObj)
//        Login login = session.login
//        Athlete athlete = athleteService.getAthleteById(login.athlete.id)
//        if(jsonObj != null) {
//            println "request obj in index after forward is ${request.getAttribute("jsonObj")}"
//            def tokens = request.getParameter("jsonObj")
//            println "token 1 is ${tokens.getClass()} ${params.toString()}"
//            AthleteCommand athleteCommand = new AthleteCommand()
//            athleteCommand.accessToken = params.access_token
//            athleteCommand.refreshToken = params.refresh_token
//            athleteCommand.acceptedScopes = params.scope
//            athleteCommand.expiresAt = params.expires_at
//            println "athlete command is ${athleteCommand.accessToken}"
//            println "athlete command is ${athleteCommand.refreshToken}"
//            println "athlete command is ${athleteCommand.acceptedScopes}"
//            println "athlete command is ${athleteCommand.expiresAt}"
//            athlete.refreshToken = athleteCommand.refreshToken
//            athlete.accessToken = athleteCommand.accessToken
//            athlete.acceptedScopes = athleteCommand.acceptedScopes
//            athlete.expiresAt = athleteCommand.expiresAt
//            athleteService.save(athlete)
//        }
//
//
////        render("Athlete API" + userInfo)
//
//        forward(action: "getUserInfo")
////        redirect(action: "getUserInfo")
//    }
//
//
//    def getUserInfo() {
//        Login login = session.login
//        println " params in getUserInfo is ${params.toString()}"
//        Athlete athlete = athleteService.getAthleteById(login.athlete.id)
//        def athlete_api = grailsApplication.config.oauth.providers.strava.athlete_api
//        def userInfo
//        def http = new HTTPBuilder('http://localhost:8080/');
//        http.request(Method.GET) {
//            uri.path = athlete_api
//            headers.Authorization = "Bearer ${params.access_token}"
//            response.success = { resp, json ->
////                println "Get response status: ${resp.statusLine}"
//                userInfo = json
//            }
//        }
////        render("Athlete API" + userInfo)
//        forward(action: "activities")
//    }
//
//    def activities() {
//        def activityList
//        def http = new HTTPBuilder('http://localhost:8080/');
//        http.request(Method.GET) {
//            uri.path = grailsApplication.config.oauth.providers.strava.activity_api
//            uri.query = [per_page: 10, before: 1667557489]
//            headers.Authorization = "Bearer ${params.access_token}"
//            response.success = { resp, json ->
////                println "Get response status: ${resp.statusLine}"
//                activityList = json
//            }
//        }
//        for (item in activityList) {
//            Activity activity = new Activity();
//            if (activityService.checkIfAlreadyPresent(item.id) != true) {
//                activity.activity = item.type
//                activity.startDate = activityService.startDateConverter(item.start_date_local)
//                activity.endDate = activityService.endDateConverter(item.start_date_local, item.moving_time)
//                activity.pace = item.average_speed
//                activity.externalId = item.id
//                activity.athlete = Athlete.get(session.login.athlete.id)
//                activity.save()
//            }
//        }
//        forward controller: "athlete", action: "index"
//    }
//




//    def checkAuthorization() {
//        def urlWithCode = grailsApplication.config.oauth.providers.strava.callBackUrl
//        def tokenUrl = grailsApplication.config.oauth.providers.strava.tokenUrl
//        def code = params.code
//        print "code is ${code}"
//        def client_id = grailsApplication.config.oauth.providers.strava.client_id
//        def clientSecret = grailsApplication.config.oauth.providers.strava.client_secret
//        def callBackURL = grailsApplication.config.oauth.providers.strava.callBackUrl
//        def http = new HTTPBuilder('http://localhost:8080/')
//        http.request(Method.POST) { req ->
//            uri.path = tokenUrl
//            requestContentType = "application/x-www-form-urlencoded"
//            body = [
//                    code: code,
//                    client_id: client_id,
//                    client_secret: clientSecret,
//                    redirect_uri: callBackURL,
//                    grant_type: "authorization_code"
//            ]
//            response.success = { resp, json ->
//                println "POST response status: ${resp.statusLine}"
//                googleJsonResponseForAccessToken = json
//                googleaccesstoken = json.access_token
//            }
//        }
//
//        render ("Access Token = " + response)
//    }


}
