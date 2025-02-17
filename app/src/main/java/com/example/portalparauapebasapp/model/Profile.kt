package com.example.portalparauapebasapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Profile(
    @StringRes val nickname: Int,
    @DrawableRes val avatar: Int,
    @StringRes val aboutMe: Int,
    val posts: Int,
    val followers: Int
)