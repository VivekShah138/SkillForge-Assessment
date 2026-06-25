package com.example.skillforge.utils

import java.text.NumberFormat
import java.util.Locale

fun Int.toFormattedNumber(): String {
    return NumberFormat.getNumberInstance(Locale.US).format(this)
}