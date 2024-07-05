package com.donaldlwandle.cleanarchitecturenotes.business.domain.utils


import java.text.SimpleDateFormat
import javax.inject.Inject
import javax.inject.Singleton


// The class for Date and time conversions in the entire application
// Every date conversion in any layer of this application will make use of this util class

@Singleton
class DateUtil

@Inject
constructor(
    private val dateFormat: SimpleDateFormat
){
    // date format for displaying in a recyclerview note item
    // date format: "yyyy-mm-dd HH:mm:ss"
    // displayed on note items:yyyy-mm-dd"(removed the time stamp)
    fun removeTimeFromDateString(dateString: String) : String{
        return dateString.substring(0,dateString.indexOf(" "))
    }

    // converting firebase time stamp to a string date
    fun convertFireBaseTimestampToStringDate(){

    }
}