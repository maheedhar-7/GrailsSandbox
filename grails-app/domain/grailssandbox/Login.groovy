package grailssandbox

class Login {

    String uuid
    String email
    Athlete  athlete

    static belongsTo = [athlete: Athlete]

    static constraints = {
    }
}
