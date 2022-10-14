package com.gapvak.athelete.controller

import com.gapvak.athlete.domain.Athlete
import com.gapvak.athlete.domain.Login
import com.gapvak.athlete.service.ActivityService
import com.gapvak.athlete.domain.Activity

import java.text.SimpleDateFormat

class ActivityController {

    ActivityService activityService

//    def index() {
//        Login login = session.login
//        Date date = new Date()
//        print "Date in the ActivityController is ${date}"
//        render view: "/athlete/index", model: [
////                activityService.list() as grails.converters.JSON,
//        ]
//    }


    def show(Long id) {
        render activityService.get(id) as grails.converters.JSON
    }


    def edit() {
        println "params in activity is ${params}"
        Long activityId = params.long('activityId')
        println "activityId in edit is ${activityId}"
        ActivityCommand activityCommand = new ActivityCommand()
        if (activityId) {
            Activity activity = activityService.getActivityById(activityId)
            activityCommand.id = activity.id
            activityCommand.activity = activity.activity
            activityCommand.startDate = activity.startDate
            activityCommand.endDate = activity.endDate
            activityCommand.pace = activity.pace
        }
        render view: "/activity/form", model: [
                activityCommand: activityCommand
        ]
    }


    def save(ActivityCommand activityCommand) {

        if (!activityCommand.validate()) {
            render view: "/activity/form", model: [
                    activityCommand: activityCommand
            ]
            return
        }

        Activity activity

        if (activityCommand.id) {
            activity = activityService.getActivityById(activityCommand.id)
        } else {
            activity = new Activity()
        }
        activity.activity = activityCommand.activity
        activity.startDate = activityCommand.startDate
        activity.endDate = activityCommand.endDate
        activity.pace = activityCommand.pace
        activity.athlete = Athlete.get(session.login.athlete.id)
        activityService.save(activity)
        redirect controller: "athlete", action: "index"
    }

    def delete() {
        def id = params.getLong("activityId")
        activityService.delete(id)
        redirect controller: "athlete", action:"index"
    }

}
