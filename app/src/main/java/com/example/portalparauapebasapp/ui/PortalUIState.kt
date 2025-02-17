package com.example.portalparauapebasapp.ui

import com.example.portalparauapebasapp.data.NewsList
import com.example.portalparauapebasapp.data.ProfilesList
import com.example.portalparauapebasapp.model.News
import com.example.portalparauapebasapp.model.Profile
import com.example.portalparauapebasapp.model.ScreenType

data class PortalUIState(

    // Variável que exibe a tela respectiva ao botão de navegação pressionado.
    val currentTab: ScreenType = ScreenType.NEWS,
    // Variável que exibe o perfil selecionado.
    val currentProfile: Profile = ProfilesList.getProfilesList().first(),
    // Variável que indica se a tela de alteração de perfil deve ser exibida.
    val switchProfileDialogOpened: Boolean = false,
    // Variável com os dados das notícias.
    val newsList: List<News> = NewsList.getNewsList(),
    // Variável que seta moreInformation das notícias como falso.
    val moreInformartion: Map<Int, Boolean> = newsList.indices.associateWith { false }
)
