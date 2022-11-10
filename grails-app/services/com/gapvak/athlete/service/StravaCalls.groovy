package com.gapvak.athlete.service

import groovyx.net.http.HTTPBuilder

class StravaCalls extends Thread {



    public void run() {
        def http = new HTTPBuilder("https://www.strava.com/api/v3/athlete/activities");

    }
}
