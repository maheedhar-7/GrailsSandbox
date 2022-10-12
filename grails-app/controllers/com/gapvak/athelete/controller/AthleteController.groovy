package com.gapvak.athelete.controller

import com.gapvak.athlete.service.AthleteService
import com.gapvak.athlete.domain.Athlete
import com.gapvak.athlete.domain.Login

class AthleteController {

    AthleteService athleteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", show: "GET"]

    def index() {
//        if (session.getAttribute("login") == null) {
//            render view: "/login/index"
//            return true
//        }
        Login login = session.login
        Athlete athlete = athleteService.getAthleteById(login.athlete.id)
        def activities = athlete.getActivities()
        render view: "/athlete/index", model: [
            activities: activities,
            login: login
        ]
    }

    def getAthletes() {
        List<Athlete> athletes = athleteService.list()
        render view: "/athlete/athletelist", model: [
                athletes: athletes
        ]
    }


    def edit() {
        Long athleteId = params.long('id')
        AthleteCommand athleteCommand = new AthleteCommand()
        if(athleteId) {
            Athlete athlete =  athleteService.getAthleteById(athleteId)
            // transfer data from the domain to command
            athleteCommand.id = athlete.id
            athleteCommand.firstName = athlete.firstName
            athleteCommand.lastName = athlete.lastName
            athleteCommand.phoneNumber = athlete.phoneNumber
            athleteCommand.email = athlete.email
            athleteCommand.password = athlete.password
        }
        render view: "/athlete/form", model: [
            athleteCommand: athleteCommand
        ]
    }

    def save(AthleteCommand athleteCommand) {
        if(!athleteCommand.validate()) {
            render view: "/athlete/form", model: [
                athleteCommand: athleteCommand
            ]
            return
        }

        // duplicate check
        def existingAthlete = Athlete.findAllByEmail(athleteCommand.email)
        println "====Existing Athlete ${existingAthlete}"
        if(existingAthlete.size() > 1 || (existingAthlete.size() == 1 && existingAthlete.id != athleteCommand.id)) {
            println "Rejecting the Email----"
            // reject the email field
            athleteCommand.errors.rejectValue('email', "duplicate")
            render view: "/athlete/form", model: [
                    athleteCommand: athleteCommand
            ]
            return
        }


        Athlete athlete
        if(athleteCommand.id) {
            athlete =  athleteService.getAthleteById(athleteCommand.id)
        }
        else {
            athlete = new Athlete()
        }
        athlete.firstName = athleteCommand.firstName
        athlete.lastName = athleteCommand.lastName
        athlete.phoneNumber = athleteCommand.phoneNumber
        athlete.password = athleteCommand.password
        athleteService.save(athlete)
        redirect controller: "athlete", action: "getAthletes"
    }

    def deleteAthlete() {
        List<Athlete> athletes = athleteService.list()
        def id = params.getLong("athleteId")
        println "athleteid in session is ......... ${session.login.athlete.id}"
        println "params in athlete delete is ${params}"
        println "id in delete is ${id}"
        if (session.login.athlete.id == id) {
            render view: "/athlete/athletelist", model: [
                    athletes: athletes,
                    msg: "Cannot delete the user with the current session"
            ]
            println "to see wether the smt execute"
            return false
        }
        athleteService.delete(id)
        redirect controller: "athlete", action: "getAthletes"
    }

    def pageView() {
        render view: "/athlete/form", model: [
                formTitle: "Add Athlete"
        ]
    }

    def updateAthlete() {
        print "Coming to the update in athlete controller----------"

        def id = params.getLong("athleteId")
        def athlete = athleteService.getAthleteById(id)
        print "athlete in athCon update is ${athlete as grails.converters.JSON}"
        render view: "/athlete/form", model: [
                athlete: athlete,
//                athleteCommand: athleteCommand,
                formTitle: "Update Athlete",
                id: id
        ]
    }

}
