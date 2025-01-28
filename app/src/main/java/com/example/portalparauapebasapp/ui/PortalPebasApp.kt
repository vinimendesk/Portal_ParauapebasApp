package com.example.portalparauapebasapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.portalparauapebasapp.R
import com.example.portalparauapebasapp.data.NavigationContentList
import com.example.portalparauapebasapp.model.NavigationItemContent
import com.example.portalparauapebasapp.model.ScreenType
import com.example.portalparauapebasapp.text.fontAppBar
import com.example.portalparauapebasapp.ui.theme.Pink
import com.example.portalparauapebasapp.ui.theme.PortalParauapebasAppTheme

// Função de inicialização do aplicativo que será chamada no MainActivity.
@Composable
fun PortalPebaApp (modifier: Modifier = Modifier) {
    Scaffold(
        // Define a função da barra superior.
        topBar = { PortalPebaAppBar() },
        // Define a função da barra de navegaçãi inferior.
        bottomBar = { PortalPebaBottomNavigation(
            currentTab = ScreenType.NEWS,
            navigationItemContentList = NavigationContentList.getNavigationContentList(),
            onTabPressed = {  },
        ) }
    ) {paddingValues ->
        // Função da tela de notícias.
        Column() {
            NewsScreen(modifier = Modifier.padding(paddingValues))
            // Problema de exibição com o card de descrição da noticia.
            //NewsContentDescription()
        }
    }
}

// Função da barra superior do App.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortalPebaAppBar() {
    // Função da barra superior que alinha tudo no centro.
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Pink
        ),
        title = {
            Text(
                fontFamily = fontAppBar,
                text = stringResource(R.string.portal_parauapebas_appBarTex)
                 )
        }
    )
}

// Função da barra de navegação inferior.
@Composable
fun PortalPebaBottomNavigation(
    currentTab: ScreenType,
    onTabPressed: () -> Unit,
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.screenType,
                onClick = onTabPressed,
                icon = {
                    Icon(
                        imageVector = navItem.icon,
                        contentDescription = navItem.text
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun PortalPebasAppPreview() {
    PortalParauapebasAppTheme {
        PortalPebaApp()
    }
}