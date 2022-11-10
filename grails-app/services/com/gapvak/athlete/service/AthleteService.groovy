package com.gapvak.athlete.service

import com.gapvak.athlete.domain.Activity
import grails.transaction.Transactional
import com.gapvak.athlete.domain.Athlete
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method

@Transactional
class AthleteService {

    LoginService loginService
    ActivityService activityService
//    AthleteService stravaCallT1 = new AthleteService();

    Map<Long, Athlete> database = [:]
    long idGenerator = 0

    def serviceMethod() {

    }

    def save(athlete) {
        athlete.save(failOnError: true)
    }

    def getAthleteById(id){
        Athlete.get(id)
    }

    def list() {
        Athlete.list()
    }

    def delete(id){
        Athlete athlete = new Athlete()
        athlete = Athlete.findById(id)
        loginService.delete(athlete)
        Athlete.get(id).delete()
    }

    Athlete syncActivities(athlete) {


        def http = new HTTPBuilder("https://www.strava.com/api/v3/athlete/activities");
        println "athlete id is ${athlete.id}"
        def activityList
        http.request(Method.GET) {
            uri.query = [per_page: 10, before: 1667557489]
            headers.Authorization = "Bearer ${athlete.accessToken}"
            response.success = { resp, json ->
//                println "Get response status: ${resp.statusLine}"
                println "json in the syncactivities is ${json}"
                activityList = json
            }
        }
        for (item in activityList) {
            Activity activity = new Activity();
            if (activityService.checkIfAlreadyPresent(item.id) != true) {
                activity.activity = item.type
                activity.startDate = activityService.startDateConverter(item.start_date_local)
                activity.endDate = activityService.endDateConverter(item.start_date_local, item.moving_time)
                activity.pace = item.average_speed
                activity.externalId = item.id
                activity.athlete = Athlete.get(athlete.id)
                activity.save()
            }
        }
    }

    Athlete findByEmailAndPassword(String email, String password) {
        Athlete athlete = Athlete.findByEmailAndPassword(email, password)
        athlete
    }

//    Athlete findByAccessToken(accesstoken) {
//        Athlete athlete = Athlete.findByAccessToken(accesstoken)
//        athlete
//    }

    Athlete findByUsername(userName) {
        Athlete athlete = Athlete.findByUserName(userName)
        athlete
    }

    Athlete get(Serializable id) {
        database[id]
    }

     def update(Athlete athlete, Long id) {
        Athlete existingAthlete = Athlete.findById(id)
         existingAthlete.setFirstName(athlete.getFirstName())
        existingAthlete.setLastName(athlete.getLastName())
        existingAthlete.setPhoneNumber(athlete.getPhoneNumber())
        existingAthlete.setEmail(athlete.getEmail())
        save(athlete)
    }
}
