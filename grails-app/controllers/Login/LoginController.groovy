package Login

import grailssandbox.Login
import login.LoginService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestParam

class LoginController {

    LoginService loginService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


//    def index(@RequestParam String email, @RequestParam String password) {
//
//        Login loginObj;
//        loginObj = loginService.login(email, password);
//        print ("email and password in the loginController is " + email +", " + password);
//        print ("login obj in logincontroller " + loginObj);
//        if (loginObj == null) {
////			return new ResponseEntity<Login>(loginService.loginFailResponse(), HttpStatus.BAD_REQUEST)
////            return new ResponseEntity("email or password is incorrect", HttpStatus.BAD_REQUEST);
//            redirect action: "processLogin", method: "POST"
//        } else {
//            render login as grails.converters.JSON;
//        }
//
//    }

    Login login(@RequestParam("email") String email, @RequestParam("password") String password) {
        Login loginObj;
        loginObj = loginService.login(email, password);
        print ("email and password in the loginController is " + email +", " + password);
        print ("login obj in logincontroller " + loginObj);
        if (loginObj == null) {
            render "Invalid UserName and Password"
        } else {
            render loginObj as grails.converters.JSON;
        }
    }


}
