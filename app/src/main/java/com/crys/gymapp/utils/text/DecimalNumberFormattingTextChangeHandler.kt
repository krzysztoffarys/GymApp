package com.crys.gymapp.utils.text

import com.crys.gymapp.utils.text.StringConsts.DOT
import com.crys.gymapp.utils.text.StringConsts.EMPTY
import com.crys.gymapp.utils.text.StringConsts.FRACTION_DIGITS
import com.crys.gymapp.utils.text.StringConsts.SEPARATOR_COMMA


class DecimalNumberFormattingTextChangeHandler(
    private val decimalNumberParser: DecimalNumberParser,
    private val maxValue: Double
) {

    companion object {
        private val VALUE_FORMAT_REGEX = "^\\d*+([$DOT$SEPARATOR_COMMA]\\d{0,$FRACTION_DIGITS})?\$".toRegex()
    }

    private var previousText = EMPTY

    fun checkAndAdjustIfNecessary(text: String): String {
        if (text.isTextValid()) {
            previousText = coerceAtMostToMaxValue(text)
        }
        return previousText
    }

    private fun String.isTextValid(): Boolean = VALUE_FORMAT_REGEX.matches(this)

    private fun coerceAtMostToMaxValue(text: String): String =
        if (isNumberBiggerThanMax(text)) maxValue.toString() else text

    private fun isNumberBiggerThanMax(numberAsText: String): Boolean {
        val number = decimalNumberParser.parse(numberAsText) ?: return false
        return number > maxValue
    }
}