package com.example.portalparauapebasapp.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.portalparauapebasapp.model.Profile
import com.example.portalparauapebasapp.R

object ProfilesList {
    @Composable
    fun getProfilesList(): List<Profile> {
        return listOf(
            Profile(
                nickname = stringResource(R.string.vinicius_mendes_author),
                avatar = painterResource(R.drawable.viniciusprojeto),
                aboutMe = stringResource(R.string.vini_aboutme),
                followers = 198000,
                posts = 2
            ),
            Profile(
                nickname = stringResource(R.string.rodolfoblox_nickname),
                avatar = painterResource(R.drawable.rodolfoblox),
                aboutMe = stringResource(R.string.rodolfoblox_aboutme),
                followers = 670,
                posts = 93
            ),
            Profile(
                nickname = stringResource(R.string.donabenta_nickname),
                avatar = painterResource(R.drawable.donabenta),
                aboutMe = stringResource(R.string.donabenta_aboutme),
                followers = 2500000,
                posts = 56
            ),
            Profile(
                nickname = stringResource(R.string.mariana_cardoso_author),
                avatar = painterResource(R.drawable.marianaprojeto),
                aboutMe = stringResource(R.string.mariana_cardoso_aboutme),
                followers = 1000000000,
                posts = 120
            ),
            Profile(
                nickname = stringResource(R.string.jainer_silva_author),
                avatar = painterResource(R.drawable.jainerprojeto),
                aboutMe = stringResource(R.string.jainer_silva_aboutme),
                followers = 1,
                posts = 20
            )

        )
    }
}