package com.gapvak.athelete.controller

import grails.converters.JSON
import groovyx.net.http.HTTPBuilder
import  groovyx.net.http.ContentType
import groovyx.net.http.Method

class OauthController {

    def oauthService

    def index() { }

    def authorization() {
        def authorizationUrl = grailsApplication.config.oauth.providers.strava.authorizationCodeUrl
        print "authorization url is ${authorizationUrl}"
        redirect(url: authorizationUrl, action: "checkAuthorization")
    }


    def checkAuthGetToken() {
        def urlWithCode = request.getParameter("code")
        def tokenUrl = grailsApplication.config.oauth.providers.strava.tokenUrl
        def code = params.code
        print "code is ${code}"
        def client_id = grailsApplication.config.oauth.providers.strava.client_id
        def clientSecret = grailsApplication.config.oauth.providers.strava.client_secret
        def callBackURL = grailsApplication.config.oauth.providers.strava.callBackUrl
        def http = new HTTPBuilder('http://localhost:8080/')
        def jsonObj
        http.request(Method.POST) { req ->
            uri.path = tokenUrl
            requestContentType = "application/x-www-form-urlencoded"
            body = [
                    code: code,
                    client_id: client_id,
                    client_secret: clientSecret,
                    redirect_uri: callBackURL,
                    grant_type: "authorization_code"
            ]
            response.success = { resp, json ->
//                println "POST response status: ${resp.statusLine} ${resp}"
//                googleJsonResponseForAccessToken = json
                jsonObj = json
                params.setProperty("refresh_token", json.refresh_token)
                params.setProperty("access_token", json.access_token)
//                println "access token is ${json} ${resp.toString()}"
            }
        }
        request.setAttribute("jsonObj", jsonObj)
//        render("url parems" + jsonObj + request.getParameter("code") + response.toString() + http.toString())
        forward(controller: "athlete", action: "index")
    }





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
