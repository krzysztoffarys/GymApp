package com.crys.gymapp.utils.extensions

import android.view.View

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