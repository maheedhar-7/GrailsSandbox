package com.gapvak.athlete.domain

import com.gapvak.athelete.controller.AthleteCommand

class Athlete {

    long id
    String firstName
    String lastName
    String email
    String phoneNumber
    String password
    String userName
    String accessToken
    String refreshToken
    String expiresAt
//    String acceptedScopes


    static hasMany = [activities: Activity]

    static constraints = {
//        firstName blank: false, nullable: false
//        lastName blank: false, nullable: false
//        email email: true, blank: false, nullable: false
//        phoneNumber blank: false, nullable: false, matches: "9[0-9]{10}"
//        password blank: false, nullable: false, size: 8..15
    }

    Athlete() {

    }

    Athlete (AthleteCommand athleteCommand) {
        this.firstName = athleteCommand.firstName
        this.lastName = athleteCommand.lastName
        this.email = athleteCommand.email
        this.password = athleteCommand.password
        this.accessToken = athleteCommand.accessToken
        this.refreshToken = athleteCommand.refreshToken
        this.acceptedScopes = athleteCommand.acceptedScopes
        this.expiresAt = athleteCommand.expiresAt
    }


}
