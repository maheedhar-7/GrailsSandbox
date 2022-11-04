package com.gapvak.athelete.controller

import com.gapvak.athlete.service.AthleteService
import com.gapvak.athlete.domain.Athlete
import com.gapvak.athlete.domain.Login

class AthleteController {

    AthleteService athleteService

//    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE", show: "GET"]

    def index() {
        Login login = session.login
        Athlete athlete = athleteService.getAthleteById(login.athlete.id)
        def activities = athlete.getActivities()
        if(request.getAttribute("jsonObj")) {
        println "request obj in index after forward is ${request.getAttribute("jsonObj")}"
            def tokens = request.getParameter("jsonObj")
            println "token 1 is ${tokens.getClass()} ${params.toString()}"
            AthleteCommand athleteCommand = new AthleteCommand()
            athleteCommand.accessToken = params.access_token
            athleteCommand.refreshToken = params.refreshToken
            athlete.refreshToken = athleteCommand.refreshToken
            athlete.accessToken = athleteCommand.accessToken
            athleteService.save(athlete)
        }
        render view: "/athlete/index", model: [
            activities: activities,
            login: login
        ]
    }

    def list() {
        List<Athlete> athletes = athleteService.list()
        render view: "/athlete/list", model: [
                athletes: athletes,
                msg: params.get("message")
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
        if(existingAthlete.size() > 1 || (existingAthlete.size() == 1 && existingAthlete.get(0).id != athleteCommand.id)) {
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
        athlete.email = athleteCommand.email
        athlete.password = athleteCommand.password
        athleteService.save(athlete)
        redirect controller: "athlete", action: "list"
    }

    def delete() {
        List<Athlete> athletes = athleteService.list()
        def id = params.long('id')
        println "id in delete is ${id}"
        println "athleteid in session is ......... ${session.login.athlete.id}"
        println "params in athlete delete is ${params}"
        println "id in delete is ${id}"
        if (session.login.athlete.id == id) {
//            render view: "/athlete/list", model: [
//                    athletes: athletes,
//                    msg: "Cannot delete the user with the current session"
//            ]
//            println "to see wether the smt execute"
//            return false
//            redirect action: "list"
            forward action: "list", params: [message: "Cant' delete Athlete with current session"]
            return
        }
        athleteService.delete(id)
        redirect controller: "athlete", action: "list"
    }


}
