package com.example.portalparauapebasapp.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.portalparauapebasapp.data.NavigationContentList
import com.example.portalparauapebasapp.data.ProfilesList
import com.example.portalparauapebasapp.model.ScreenType
import com.example.portalparauapebasapp.ui.components.PortalPebaAppBar
import com.example.portalparauapebasapp.ui.components.PortalPebaBottomNavigation
import com.example.portalparauapebasapp.ui.theme.PortalParauapebasAppTheme
import com.example.portalparauapebasapp.ui.theme.PortalViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

// Função de inicialização do aplicativo que será chamada no MainActivity.
@Composable
fun PortalPebaApp(portalViewModel: PortalViewModel = viewModel()) {

    // Coleta do estado atual.
    val portalUIState by portalViewModel.uiState.collectAsState()

    Scaffold(
        // Define a função da barra superior.
        topBar = { PortalPebaAppBar() },
        bottomBar = {
            // Função da barra inferior.
            PortalPebaBottomNavigation(
                currentTab = portalUIState.currentTab,
                onTabPressed = { portalViewModel.onTabPressed(it) },
                navigationItemContentList = NavigationContentList.getNavigationContentList()
            )
        }
    ) { paddingValues ->
        // Função para exibir a tela respectiva ao botão de navegação pressionado.
        ShowTab(portalUIState.currentTab, modifier = Modifier.padding(paddingValues))
    }
}

// Função para exibir a tela respectiva ao botão de navegação pressionado
@Composable
fun ShowTab(
    targetTab: ScreenType,
    portalViewModel: PortalViewModel = viewModel(),
    modifier: Modifier = Modifier) {

    // Variável com os dados dos perfis.
    val profilesList = ProfilesList.getProfilesList()

    // Coleta do estado atual.
    val portalUIState by portalViewModel.uiState.collectAsState()


    if (targetTab == ScreenType.PROFILE) {
        // Função da tela de perfil.
        ProfileScreen(
            currentProfile = portalUIState.currentProfile,
            profilesList = profilesList,
            onChangeCurrentProfile = { portalViewModel.onChangeCurrentProfile(it) },
            modifier = modifier
        )
    } else {
        // Função da tela de notícias.
        NewsScreen(modifier = modifier)
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