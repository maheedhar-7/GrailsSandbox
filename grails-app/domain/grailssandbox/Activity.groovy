package grailssandbox

import activity.ActivityCommand
import org.grails.databinding.BindingFormat

class Activity {

    @BindingFormat('yyyy-MM-dd HH:mm:ss.S')
    Date startDate
    @BindingFormat('yyyy-MM-dd HH:mm:ss.S')
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
        startDate nullable: true
        endDate nullable: true
    }


//    static mapping = {
//        athlete_id:
//    }

}
