package co.jassonkm.nimblechallenge.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DateProvider {
    fun getCurrentDateFormattedString(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("EEEE, MMMM d", Locale.ENGLISH)
        return dateFormat.format(calendar.time).uppercase()
    }
}