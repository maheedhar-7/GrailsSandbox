package com.gapvak.athlete.service


import grails.transaction.Transactional
import com.gapvak.athlete.domain.Athlete
import com.gapvak.athlete.domain.Login

@Transactional
class LoginService {

    AthleteService athleteService

    def serviceMethod() {

    }

    def generateId() {
        UUID uuid =UUID.randomUUID();
        String uuidAsString =  uuid.toString();
        System.out.println(uuidAsString);
        uuidAsString;
    }

    Login login(String email, String password) {
        Login login = null;
        Athlete athlete = athleteService.findByEmailAndPassword(email, password);
        System.out.println("Athlete in LoginServiceImpl is " + athlete);
        if(athlete != null) {
            login = new Login();
            login.setAthlete(athlete);
            login.setUuid(generateId());
            login.setEmail(email);
            System.out.println("login in LoginServiceImpl is " + login);
            save(login);
        }
        login;
    }

    def delete(Athlete athlete) {
        List<Login> logins = Login.findAllByAthlete(athlete)
        print logins
        for (item in logins) {
            print item.getAthlete()
            item.delete()
        }
    }

    Login save(login) {
        login.save()
    }

    Login findByToken(String uuid) {
        Login login = Login.findByUuid(uuid);
        login
    }


}
