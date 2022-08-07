package com.crys.gymapp.utils

import android.content.res.ColorStateList
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorInt
import androidx.core.content.getSystemService
import androidx.core.view.isVisible
import com.google.android.material.textfield.TextInputLayout

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.setInvisible() {
    visibility = View.INVISIBLE
}

fun View.measureAndGetWidth(): Int {
    val measureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    measure(measureSpec, measureSpec)
    return measuredWidth
}

fun View.setVisibleOrGone(visible: Boolean) {
    if (visible) {
        show()
    } else {
        hide()
    }
}

fun View.enable() {
    isEnabled = true
}

fun View.disable() {
    isEnabled = false
}