package grailssandbox

import login.LoginService

class LoginFilters {

    LoginService loginService

    def filters = {

        notLogin(controller:'login', invert:true) {
            before = {
//                boolean authenticated = false
//                String uuid = request.getHeader("uuid")
//                print "uuid in login filter is " + uuid
//                print loginService.findByToken(uuid)
//                if ((uuid != null) && (loginService.findByToken(uuid) != null)) {
//                    authenticated = true
//                }
//                if (!authenticated) {
//                    render "Cant able to login because the is no id"
//                }
//                return authenticated
                return true
            }
        }
    }
}
