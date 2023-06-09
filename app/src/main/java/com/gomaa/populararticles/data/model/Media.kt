package com.gomaa.populararticles.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Media(
    val caption: String,
    val copyright: String,
    val mediaMetadata: List<MediaMetadata>,
    val subtype: String,
    val type: String
) : Parcelable