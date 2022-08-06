package com.crys.gymapp.feature_weight.presentation.weight

import java.util.Calendar
import java.util.Date
import javax.inject.Inject

class DateProvider @Inject constructor() {

    fun getTodayDate(): Long = Calendar.getInstance().apply {
        time = Date(System.currentTimeMillis())
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.time.time
}