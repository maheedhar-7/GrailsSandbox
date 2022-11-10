package com.gapvak.athelete.controller

import com.gapvak.athlete.domain.Athlete
import com.gapvak.athlete.domain.Login
import com.gapvak.athlete.service.LoginService
import org.springframework.web.bind.annotation.RequestParam

class LoginController {

    LoginService loginService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def login() {
        render view: "/login/index"
    }

    Login loginValidate(@RequestParam("email") String email, @RequestParam("password") String password) {
        println "Authenticating User ${email}:${password}"
        Login login = loginService.login(email, password)
        println "Authentication Result ${login}"
        println "session.get login attr ${session.getAttribute("login")} ${session as grails.converters.JSON}"
        if(login != null) {
            session.login = login
//            def cookieService = cook
            println "in login is ${session.login as grails.converters.JSON}"
            println "session.get login attr ${session.getAttribute("login") as grails.converters.JSON} ${session as grails.converters.JSON}"
            redirect controller: 'athlete', action: 'index'
        }
        else {
            render view: '/login/index', model: [
                    email: email,
                    password: password,
                    message: "Email or Password is incorrect"
            ]
        }
    }

    def logout() {
        println "session in logout is ${session as grails.converters.JSON}"
        println "session login is ${session.getAttribute("login")}"
        session.invalidate()
        redirect controller: "login", action: "login"
    }

}
