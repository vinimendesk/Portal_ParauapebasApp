package com.example.portalparauapebasapp.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.portalparauapebasapp.R
import com.example.portalparauapebasapp.model.NavigationItemContent
import com.example.portalparauapebasapp.model.ScreenType

object NavigationContentList {
    @Composable
    fun getNavigationContentList(): List<NavigationItemContent> {
        val context = LocalContext.current
        return listOf(
            NavigationItemContent(
                screenType = ScreenType.NEWS,
                icon = Icons.AutoMirrored.Filled.Send,
                text = context.getString(R.string.news_NavigationItem)
            ),
            NavigationItemContent(
                screenType = ScreenType.PROFILE,
                icon = Icons.Default.AccountCircle,
                text = context.getString(R.string.my_profile_NavigationItem)
            )
        )
    }
}