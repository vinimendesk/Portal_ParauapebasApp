package com.example.portalparauapebasapp.model

import androidx.compose.ui.graphics.painter.Painter

data class Profile(
    val nickname: String,
    val avatar: Painter,
    val aboutMe: String,
    val posts: Int,
    val followers: Int
)