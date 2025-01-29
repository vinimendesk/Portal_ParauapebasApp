package com.example.portalparauapebasapp.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.portalparauapebasapp.model.NewsItemContent

import com.example.portalparauapebasapp.R

object NewsList {
    @Composable
    fun getNewsList(): List<NewsItemContent> {
        val context = LocalContext.current
        return listOf(
            NewsItemContent(
                author = R.string.vinicius_mendes_author,
                description = R.string.news_description_vini,
                profilePhoto = R.drawable.eu,
                time = 5,
                title = R.string.title_vini_post
            ),
            NewsItemContent(
                author = R.string.jainer_silva_author,
                description = R.string.news_description_jainer,
                profilePhoto = R.drawable.jainerprojeto,
                time = 8,
                title = R.string.jainer_description_post
            ),
            NewsItemContent(
                author = R.string.mariana_cardoso_author,
                description = R.string.news_description_mariana,
                profilePhoto = R.drawable.marianaprojeto,
                time = 12,
                title = R.string.mariana_title_post
            )
        )
    }
}