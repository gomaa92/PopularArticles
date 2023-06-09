package com.gomaa.populararticles.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val id: Long?,
    val media: List<Media>?,
    @SerializedName("published_date") val publishedDate: String?,
    val section: String?,
    val source: String?,
    val subsection: String?,
    val title: String?,
    val type: String?,
    val updated: String?,
    val uri: String?,
    val url: String?,
    @SerializedName("byline") val byline: String?,
    ) : Parcelable