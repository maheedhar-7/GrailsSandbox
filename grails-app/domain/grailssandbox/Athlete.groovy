package grailssandbox

class Athlete {

    long id
    String firstName
    String lastName
    String email
    String phoneNumber
    String password


    static hasMany = [activities: Activity]

//    static constraints = {
//        password size: 5..20, blank: false
//        email size: 5..30, blank: false, unique: true
//        firstName size: 2..25, blank: false
//        lastName size: 2..25, blank: false
//        phoneNumber size: 10..12, blank: false
//    }
}
