package com.gapvak.athelete.controller

import grails.validation.Validateable
import org.grails.databinding.BindingFormat

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

@Validateable
class ActivityCommand {
    long id
    String pace
    String activity
//    @BindingFormat('dd/MM/yyyy HH:mm:ss')
    Date startDate
//    @BindingFormat('dd/MM/yyyy HH:mm:ss')
    Date endDate

    final static DateFormat DATEFORMAT = new SimpleDateFormat('dd/MM/yyyy HH:mm')


    static constraints = {
        pace nullable: false
        startDate nullable: false, matches: "^\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}[AP]M\$\n"
        endDate nullable: false, matches: "^\\d{2}-\\d{2}-\\d{4} \\d{2}:\\d{2}[AP]M\$\n"
    }
}