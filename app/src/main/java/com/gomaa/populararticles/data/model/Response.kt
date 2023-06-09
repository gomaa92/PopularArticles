package com.gomaa.populararticles.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticlesResponse(
    val copyright: String?,
    val numResults: Int?,
    @SerializedName("results") val articles: List<Article>,
    val status: String?
) : Parcelable