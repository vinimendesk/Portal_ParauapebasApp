package com.example.portalparauapebasapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.portalparauapebasapp.data.NavigationContentList
import com.example.portalparauapebasapp.model.ScreenType
import com.example.portalparauapebasapp.ui.components.PortalPebaAppBar
import com.example.portalparauapebasapp.ui.components.PortalPebaBottomNavigation
import com.example.portalparauapebasapp.ui.theme.PortalParauapebasAppTheme

@Composable
fun PortalPebaApp () {
    var currentTab by remember { mutableStateOf(ScreenType.NEWS) }

    Scaffold(
        // Define a função da barra superior.
        topBar = { PortalPebaAppBar() },
        bottomBar = {
            PortalPebaBottomNavigation(
                currentTab = currentTab,
                onTabPressed = { pressedTab -> currentTab = pressedTab },
                navigationItemContentList = NavigationContentList.getNavigationContentList()
            )
        }
    ) { paddingValues ->
        ShowTab(currentTab, Modifier.padding(paddingValues))
    }
}

// função para exibir a tela respectiva ao botão de navegação pressionado
@Composable
fun ShowTab(targetTab: ScreenType, modifier: Modifier = Modifier) {
    if (targetTab == ScreenType.PROFILE) {
        ProfileScreen(modifier)
    } else {
        NewsScreen(modifier)
    }
}

// preview do design geral do aplicativo + outras telas
@Preview
@Composable
fun PortalPebasAppPreview() {
    PortalParauapebasAppTheme {
        PortalPebaApp()
    }
}