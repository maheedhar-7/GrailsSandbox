package activity

class ActivityCommand {
    String pace
    String activity
    Date startDate
    Date endDate

    static constraints = {
//        startDate max: new Date(), nullable: true
//        endDate max: new Date(), nullable: true
        startDate nullable: true
        endDate nullable: true
    }
}
