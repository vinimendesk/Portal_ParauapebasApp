package com.example.portalparauapebasapp.data

import com.example.portalparauapebasapp.R
import com.example.portalparauapebasapp.model.News

object NewsList {
    fun getNewsList(): List<News> {
        return listOf(
            News(
                author = R.string.vinicius_mendes_author,
                authorAvatar = R.drawable.viniciusprojeto,
                title = R.string.title_vini_post,
                description = R.string.news_description_vini,
                postTime = R.string.post_time_vini
            ),
            News(
                author = R.string.jainer_silva_author,
                authorAvatar = R.drawable.jainerprojeto,
                title = R.string.title_jainer_post,
                description = R.string.news_description_jainer,
                postTime = R.string.post_time_jainer
            ),
            News(
                author = R.string.mariana_cardoso_author,
                authorAvatar = R.drawable.marianaprojeto,
                title = R.string.title_mariana_post,
                description = R.string.news_description_mariana,
                postTime = R.string.post_time_mariana
            )
        )
    }
}