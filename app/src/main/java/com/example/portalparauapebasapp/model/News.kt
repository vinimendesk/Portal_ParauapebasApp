package com.example.portalparauapebasapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class News(
    @StringRes val author: Int,
    @DrawableRes val authorAvatar: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @StringRes val postTime: Int
)