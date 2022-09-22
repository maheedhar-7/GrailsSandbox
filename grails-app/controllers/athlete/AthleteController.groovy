package athlete

import grailssandbox.Activity
import grailssandbox.Athlete
import grailssandbox.Login

class AthleteController {

    AthleteService athleteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", show: "GET"]


//    def display() {
//        print "the session in the display is ${session.getAttribute("loginObj")}"
//        Login loginGetAttri = session.getAttribute("loginObj")
//        Athlete athlete = athleteService.getAthleteById(loginGetAttri.getAthleteId())
//        List<Activity> activities = athlete.getActivities()
//        print "login getAttri is ${activities as grails.converters.JSON}"
////        print "activities in display is ${athleteId as grails.converters.JSON}"
//    }


    def index() {
        render athleteService.list() as grails.converters.JSON
    }

    def show(Long id) {
        render athleteService.getAthleteById(id) as grails.converters.JSON
    }

    def save(Athlete athlete) {
        print "athleteObj in athlete controller is ${athlete as grails.converters.JSON}"
        athleteService.save(athlete)
        render athlete as grails.converters.JSON
    }


    def delete(Long id) {
        athleteService.delete(id)
        redirect action:"index", method:"GET"
    }

    def update(Athlete athlete, Long id) {
        athleteService.update(athlete, id)
        redirect action:"index", method:"GET"
    }

}
