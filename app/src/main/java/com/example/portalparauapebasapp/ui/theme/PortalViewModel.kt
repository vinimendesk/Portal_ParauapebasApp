package com.example.portalparauapebasapp.ui.theme

import androidx.lifecycle.ViewModel
import com.example.portalparauapebasapp.model.Profile
import com.example.portalparauapebasapp.model.ScreenType
import com.example.portalparauapebasapp.ui.PortalUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PortalViewModel : ViewModel() {

    // Variável que armazena o estado da tela.
    private val _uiState = MutableStateFlow(PortalUIState())
    // Variável que coleta os dados do estado da tela.
    val uiState: StateFlow<PortalUIState> = _uiState.asStateFlow()

    // Função que altera a tela atual.
    fun onTabPressed (pressedTab: ScreenType) {
        _uiState.value = _uiState.value.copy(currentTab = pressedTab)
    }

    // Função que altera o perfil atual.
    fun onChangeCurrentProfile (profile: Profile) {
        _uiState.value = _uiState.value.copy(currentProfile = profile)
    }

    // Função que permite abrir a tela de alteração de perfil.
    fun onClickButtonSwitchProfile() {
        _uiState.value = _uiState.value.copy(switchProfileDialogOpened = true)
    }

    // Função que fecha a tela de alteração de perfil.
    fun onDimissRequest() {
        _uiState.value = _uiState.value.copy(switchProfileDialogOpened = false)
    }

}