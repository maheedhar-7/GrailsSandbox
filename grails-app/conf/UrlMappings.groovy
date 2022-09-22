class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/login"(controller: "login", action: "login")
        "/api/athletes"(controller: "athlete", action: "save", method: "POST")
        "/api/athletes"(controller: "athlete", action: "index", method: "GET")
        "/api/athletes/$id"(controller: "athlete", action: "show", method: "GET")
        "/api/athletes/$id"(controller: "athlete", action: "delete", method: "DELETE")
        "/api/athletes/$id"(controller: "athlete", action: "update", method: "PUT")

        "/api/activities/$id"(controller: "activity", action: "save", method: "POST")
        "/api/activities"(controller: "activity", action: "index", method: "GET")
        "/api/activities/$id"(controller: "activity", action: "show", method: "GET")
        "/api/activities/$id"(controller: "activity", action: "delete", method: "DELETE")
        "/api/activities/$id"(controller: "activity", action: "update", method: "PUT")


//        "/"(view:"/index")
//        "500"(view:'/error')
	}
}
