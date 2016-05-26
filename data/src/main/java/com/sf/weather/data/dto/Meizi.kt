package com.sf.weather.data.dto

import com.google.gson.annotations.SerializedName
import nz.bradcampbell.paperparcel.PaperParcel

@PaperParcel
data class Meizi(
        @SerializedName("_id") val id: String,
        val type: String,
        val url: String,
        val who: String
)