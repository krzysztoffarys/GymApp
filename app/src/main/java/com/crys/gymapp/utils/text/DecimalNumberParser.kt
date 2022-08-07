package com.crys.gymapp.utils.text

import com.crys.gymapp.utils.text.StringConsts.DOT
import com.crys.gymapp.utils.text.StringConsts.SEPARATOR_COMMA
import javax.inject.Inject

class DecimalNumberParser @Inject constructor() {

    fun parse(text: String): Double? = text.replace(SEPARATOR_COMMA, DOT)
        .let(::addZeroIfFirstDigitIsSeparator)
        .let(::dropLastCharIfIsSeparator)
        .toDoubleOrNull()

    private fun addZeroIfFirstDigitIsSeparator(text: String): String {
        val firstChar = text.firstOrNull()?.toString()
        return if (firstChar == DOT) "0$text" else text
    }

    private fun dropLastCharIfIsSeparator(text: String): String {
        val lastChar = text.lastOrNull()?.toString()
        return if (lastChar == DOT) text.dropLast(1) else text
    }
}