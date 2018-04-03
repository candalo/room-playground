package com.github.roomplayground.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


object DateUtil {

    private const val DATE_IN_FULL_FORMAT = "MMMM dd, yyyy h:mm a"

    fun getDateInFull(date: Date): String {
        val simpleDateFormat = SimpleDateFormat(DATE_IN_FULL_FORMAT, Locale.getDefault())
        return simpleDateFormat.format(date)
    }

}