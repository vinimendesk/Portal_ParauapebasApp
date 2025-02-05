package com.example.portalparauapebasapp.model

import androidx.compose.ui.graphics.painter.Painter

data class News(
    val author: String,
    val authorAvatar: Painter,
    val title: String,
    val description: String,
    val postTime: String
)