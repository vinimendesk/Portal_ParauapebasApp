package com.example.portalparauapebasapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.portalparauapebasapp.model.NavigationItemContent
import com.example.portalparauapebasapp.model.ScreenType
import com.example.portalparauapebasapp.ui.theme.SelectedNavigationBarItemIconColor
import com.example.portalparauapebasapp.ui.theme.SelectedNavigationBarItemIndicatorColor
import com.example.portalparauapebasapp.ui.theme.TopBottomAppBarColor
import com.example.portalparauapebasapp.ui.theme.UnselectedNavigationBarItemIconColor
import com.example.portalparauapebasapp.ui.theme.UnselectedNavigationBarItemIndicatorColor

// Função da barra de navegação inferior.
@Composable
fun PortalPebaBottomNavigation(
    currentTab: ScreenType,
    onTabPressed: (ScreenType) -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = TopBottomAppBarColor
    ) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.screenType,
                onClick = { onTabPressed(navItem.screenType) },
                icon = {
                    Box(
                        modifier = Modifier
                            .background(
                                color = when (currentTab == navItem.screenType) {
                                    true -> SelectedNavigationBarItemIndicatorColor
                                    false -> UnselectedNavigationBarItemIndicatorColor
                                },
                                shape = CircleShape
                            )
                            .size(40.dp)
                    ) {
                        Icon(
                            imageVector = navItem.icon,
                            contentDescription = navItem.text,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    selectedIconColor = SelectedNavigationBarItemIconColor,
                    unselectedIconColor = UnselectedNavigationBarItemIconColor
                )
            )
        }
    }
}