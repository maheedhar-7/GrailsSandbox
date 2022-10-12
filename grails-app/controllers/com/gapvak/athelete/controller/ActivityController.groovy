package com.gapvak.athelete.controller

import com.gapvak.athlete.domain.Athlete
import com.gapvak.athlete.service.ActivityService
import com.gapvak.athlete.domain.Activity

import java.text.SimpleDateFormat

class ActivityController {

    ActivityService activityService

    def index() {
        Date date = new Date()
        print "Date in the ActivityController is ${date}"
        render activityService.list() as grails.converters.JSON
    }

    def pageView() {
        render view: "/activity/form", model: [
                formTitle: "Add Activity"
        ]
    }

    def show(Long id) {
        render activityService.get(id) as grails.converters.JSON
    }

    def save(ActivityCommand activityCommand) {
        print "params in save is ${params}"
        def id = params.getLong("activity-id")
        print "activity id in save ${id}"
        if (id) {
            def activity = Activity.findById(id)
            activity.pace = activityCommand.pace
            activity.startDate = activityCommand.startDate
            activity.endDate = activityCommand.endDate
            activity.activity = activityCommand.activity
            if (activity.validate()) {
                activityService.update(activity, id)
                redirect controller: "athlete", action: "index"
            } else {
                render view: "/activity/form", model: [
                        formTitle: "Update Activity",
                        activity: activity
                ]
            }
        } else {
            println "login in session acticon is ${session.login.athlete.id}"
            def activity = new Activity()
            activity.pace = activityCommand.pace
            activity.startDate = activityCommand.startDate
            activity.endDate = activityCommand.endDate
            activity.activity = activityCommand.activity
            activity.athlete = Athlete.get(session.login.athlete.id)
            println "activity startDate is ${activityCommand.startDate}"
            println "activity endDate is ${activityCommand.endDate}"
            println "params startdate and enddate is ${params.startDate}:${params.endDate}"
            if (activity.validate()) {
                activityService.save(activity)
                redirect controller: "athlete", action:"index"
            } else {
                render view: "/activity/form", model: [
                        formTitle: "Save Activity",
                        activity: activity
                ]
            }
        }
    }

    def delete() {
        def id = params.getLong("activityId")
        activityService.delete(id)
        redirect controller: "athlete", action:"index"
    }

    def update() {
        def id = params.getLong("activityId")
        print "params in update is ${params}"
        def activity = Activity.findById(id)
        println "acit startDate and end Date is ${activity.startDate} "
        print "activity in update is ${activity as grails.converters.JSON}"
        List<Activity> acti = ["Ride", "Run"]
        render view: "/activity/form", model: [
                activity: activity,
                formTitle: "Update Activity",
                id: id,
                acti: acti
        ]
    }
}
