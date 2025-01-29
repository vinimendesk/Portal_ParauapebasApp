package com.example.portalparauapebasapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class NewsItemContent (
    @DrawableRes val profilePhoto: Int,
    @StringRes val title: Int,
    @StringRes val author: Int,
    val time: Int,
    @StringRes val description: Int
)