package com.donaldlwandle.cleanarchitecturenotes.business.domain.utils


import com.google.firebase.Timestamp
import java.text.SimpleDateFormat
import java.util.Date
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
    // input date format: "yyyy-mm-dd HH:mm:ss"
    // return date only to be displayed on note items:yyyy-mm-dd"(removed the time stamp)
    fun removeTimeFromDateString(dateString: String) : String{
        return dateString.substring(0,dateString.indexOf(" "))
    }

    // converting firebase time stamp to a string date
    //input firebase date-time stamp
    // return("YYYY-mm-dd")
    fun convertFireBaseTimestampToStringDate(timestamp: Timestamp) : String{
        return dateFormat.format(timestamp.toDate())
    }

    // Convert String Date back to firestore TimeStamp
    // input date string
    // return date in firestore Timestamp format
    fun convertStringDateToFireBaseTimeStamp(dateString: String) : Timestamp{
        return Timestamp(dateFormat.parse(dateString))
    }

    // get Current Timestamp
    fun getCurrentDateTimestamp():String {
        return dateFormat.format(Date())
    }
}