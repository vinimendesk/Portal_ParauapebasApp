package com.example.portalparauapebasapp.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.portalparauapebasapp.model.News
import com.example.portalparauapebasapp.R

object NewsList {
    @Composable
    fun getNewsList(): List<News> {
        return listOf(
            News(
                author = stringResource(R.string.vinicius_mendes_author),
                authorAvatar = painterResource(R.drawable.viniciusprojeto),
                title = stringResource(R.string.title_vini_post),
                description = stringResource(R.string.news_description_vini),
                postTime = stringResource(R.string.post_time_vini)
            ),
            News(
                author = stringResource(R.string.jainer_silva_author),
                authorAvatar = painterResource(R.drawable.jainerprojeto),
                title = stringResource(R.string.title_jainer_post),
                description = stringResource(R.string.news_description_jainer),
                postTime = stringResource(R.string.post_time_jainer)
            ),
            News(
                author = stringResource(R.string.mariana_cardoso_author),
                authorAvatar = painterResource(R.drawable.marianaprojeto),
                title = stringResource(R.string.title_mariana_post),
                description = stringResource(R.string.news_description_mariana),
                postTime = stringResource(R.string.post_time_mariana)
            )
        )
    }
}