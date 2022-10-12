package com.gapvak.athlete.service

import grails.transaction.Transactional
import com.gapvak.athlete.domain.Athlete

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
        loginService.delete(athlete)
        Athlete.get(id).delete()
    }

    Athlete findByEmailAndPassword(String email, String password) {
        Athlete athlete = Athlete.findByEmailAndPassword(email, password)
        athlete
    }

    Athlete get(Serializable id) {
        database[id]
    }

     def update(Athlete athlete, Long id) {
        Athlete existingAthlete = Athlete.findById(id)
         existingAthlete.setFirstName(athlete.getFirstName())
        existingAthlete.setLastName(athlete.getLastName())
        existingAthlete.setPhoneNumber(athlete.getPhoneNumber())
        existingAthlete.setEmail(athlete.getEmail())
        save(athlete)
    }
}
