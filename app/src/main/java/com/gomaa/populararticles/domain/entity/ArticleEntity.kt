package com.gomaa.populararticles.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleEntity(
    val title: String,
    val publishedDate: String,
    val byLine: String,
    val url: String
) : Parcelable
