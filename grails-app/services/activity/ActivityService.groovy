package activity

import athlete.AthleteService
import grails.transaction.Transactional
import grailssandbox.Activity
import grailssandbox.Athlete

@Transactional
class ActivityService {

    AthleteService athleteService

    def serviceMethod() {

    }

    def save(Activity activity, Long id) {
        print "activity obj in activityService is ${activity as grails.converters.JSON}"
        def athlete = Athlete.get(id)
        activity.setAthlete(athlete)
        activity.save(failOnError: true)
    }

    def get(id){
        Activity.get(id)
    }

    def list() {
        Activity.list()
    }

    def delete(id){
        Activity.get(id).delete()
    }

    def update(Activity activity, Long id) {
        Activity existingActivity = Activity.findById(id)
        existingActivity.setStartDate(activity.getStartDate())
        existingActivity.setEndDate(activity.getEndDate())
        existingActivity.setPace(activity.getPace())
        existingActivity.setActivity(activity.getActivity())
        existingActivity.save()
    }

}
