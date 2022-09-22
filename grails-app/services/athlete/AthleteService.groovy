package athlete

import grails.transaction.Transactional
import grailssandbox.Athlete
import login.LoginService

@Transactional
class AthleteService {

    LoginService loginService

    Map<Long, Athlete> database = [:]
    long idGenerator = 0

    def serviceMethod() {

    }

    def save(athlete) {
        athlete.save()
    }

    def getAthleteById(id){
        Athlete.get(id)
    }

    def list() {
        Athlete.list()
    }

    def delete(id){
        Athlete athlete = new Athlete()
        athlete = Athlete.findById(id)
        print athlete
        loginService.delete(athlete)
        Athlete.get(id).delete()
    }

    Athlete findByEmailAndPassword(String email, String password) {
        Athlete athlete = Athlete.findByEmailAndPassword(email, password)
        println athlete
        athlete
    }

    Athlete get(Serializable id) {
        database[id]
    }

     def update(Athlete athlete, Long id) {
         print "athlete in the athlete service is ${athlete as grails.converters.JSON}"
        Athlete existingAthlete = Athlete.findById(id)
         print "athlete in the athlete service is ${existingAthlete as grails.converters.JSON}"

         existingAthlete.setFirstName(athlete.getFirstName())
        existingAthlete.setLastName(athlete.getLastName())
        existingAthlete.setPhoneNumber(athlete.getPhoneNumber())
        existingAthlete.setEmail(athlete.getEmail())
        save(athlete)
    }
}
