package com.gapvak.athlete.service

import groovyx.net.http.HTTPBuilder

class StravaCalls extends Thread {

    def athleteService

    StravaCalls(athleteService) {
        this.athleteService = athleteService
    }

    public void run() {
        while (true) {
            println "this is in the stravacalls class run"
            athleteService.syncAthleteAndActivities();
            Thread.sleep(180000)
        }
    }
}
