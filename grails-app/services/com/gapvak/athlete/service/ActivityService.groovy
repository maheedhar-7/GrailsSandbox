package com.gapvak.athlete.service


import grails.transaction.Transactional
import com.gapvak.athlete.domain.Activity
import com.gapvak.athlete.domain.Athlete

import java.text.DateFormat
import java.text.SimpleDateFormat

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

    def checkIfAlreadyPresent(id) {
        Activity activity1 = Activity.findByExternalId(id)
        if (activity1) {
            return true
        } else {
            return false
        }
    }

    def syncActivities(athlete) {

    }


    def startDateConverter(activityDate) {
        DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date startDate = originalFormat.parse(activityDate)
//        String formattedDate = targetFormat.format(date);
        println "start date is ${startDate}"
        return startDate
    }


    def endDateConverter(activitydate, movingTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        Date date = sdf.parse(activitydate)
        long getTotalMills = date.getTime() + (movingTime * 1000)
        println "date get time is ${date.getTime()} moving time is ${movingTime} gettotal mills is ${getTotalMills}"
        Date endDate = new Date(getTotalMills)
        println "end date is ${endDate}"

        return endDate
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
