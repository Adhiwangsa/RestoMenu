package com.example.restomenu

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Food(
    var name: String,
    var description: String,
    var price: String,
    val s: String,
) : Parcelable
