package activity

import grailssandbox.Activity
import grailssandbox.Athlete

import java.text.SimpleDateFormat

class ActivityController {

    ActivityService activityService

    def index() {
        Date date = new Date()
        print "Date in the ActivityController is ${date}"
        render activityService.list() as grails.converters.JSON
    }

    def show(Long id) {
        render activityService.get(id) as grails.converters.JSON
    }

    def save(ActivityCommand activityCommand) {
        def activity = new Activity(activityCommand)
        activityService.save(activity, params.getLong("id"))
        redirect action:"index", method:"GET"
    }

    def delete(Long id) {
        activityService.delete(id)
        redirect action:"index", method:"GET"
    }

    def update(ActivityCommand activityCommand, Long id) {
        def activity = new Activity(activityCommand)
        activityService.update(activity, params.getLong("id"))
        redirect action: "index", method: "GET"
    }
}
