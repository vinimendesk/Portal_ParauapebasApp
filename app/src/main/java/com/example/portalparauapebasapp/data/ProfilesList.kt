package com.example.portalparauapebasapp.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.portalparauapebasapp.model.Profile
import com.example.portalparauapebasapp.R

object ProfilesList {
    fun getProfilesList(): List<Profile> {
        return listOf(
            Profile(
                nickname = R.string.vinicius_mendes_author,
                avatar = R.drawable.viniciusprojeto,
                aboutMe = R.string.vini_aboutme,
                followers = 198000,
                posts = 2
            ),
            Profile(
                nickname = R.string.rodolfoblox_nickname,
                avatar = R.drawable.rodolfoblox,
                aboutMe = R.string.rodolfoblox_aboutme,
                followers = 670,
                posts = 93
            ),
            Profile(
                nickname = R.string.donabenta_nickname,
                avatar = R.drawable.donabenta,
                aboutMe = R.string.donabenta_aboutme,
                followers = 2500000,
                posts = 56
            ),
            Profile(
                nickname = R.string.mariana_cardoso_author,
                avatar = R.drawable.marianaprojeto,
                aboutMe = R.string.mariana_cardoso_aboutme,
                followers = 1000000000,
                posts = 120
            ),
            Profile(
                nickname = R.string.jainer_silva_author,
                avatar = R.drawable.jainerprojeto,
                aboutMe = R.string.jainer_silva_aboutme,
                followers = 1,
                posts = 20
            )

        )
    }
}