package com.gapvak.athlete.service


import grails.transaction.Transactional
import com.gapvak.athlete.domain.Activity
import com.gapvak.athlete.domain.Athlete

@Transactional
class ActivityService {

    AthleteService athleteService

    def serviceMethod() {

    }

    def save(Activity activity) {
        print "activity obj in activityService is ${activity as grails.converters.JSON}"
        activity.save(failOnError: true)
    }

    def getActivityById(id){
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
