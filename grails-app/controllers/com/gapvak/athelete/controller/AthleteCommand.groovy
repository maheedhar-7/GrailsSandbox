package com.gapvak.athelete.controller

import grails.validation.Validateable


@Validateable
class AthleteCommand {
    Long id
    String firstName
    String lastName
    String email
    String phoneNumber
    String password
    String passwordConfirm

    static constraints = {
        id nullable: true
        firstName blank: false, nullable: false
        lastName blank: false, nullable: false
        email email: true, blank: false, nullable: false
        phoneNumber blank: false, nullable: false, matches: "9[0-9]{10}"
        password blank: false, nullable: false, size: 8..15, validator: {val, obj ->
            obj.passwordConfirm == val
        }
    }

}
