package com.gapvak.athlete.domain

import com.gapvak.athelete.controller.ActivityCommand
import org.grails.databinding.BindingFormat

class Activity {

    Date startDate
    Date endDate
    String pace
    String activity
//    Athlete athlete

    Activity() {

    }

    Activity(ActivityCommand activityCommand) {
        this.startDate = activityCommand.startDate
        this.endDate = activityCommand.endDate
        this.pace = activityCommand.pace
        this.activity = activityCommand.activity
    }

    static belongsTo = [athlete: Athlete]

    static constraints = {
        activity nullable: false
        pace nullable: false
        startDate nullable: false, matches: "^\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}[AP]M\$\n"
        endDate nullable: false, matches: "^\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}[AP]M\$\n"
    }


//    static mapping = {
//        athlete_id:
//    }

}
