package com.example.portalparauapebasapp.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.portalparauapebasapp.R
import com.example.portalparauapebasapp.text.fontAppBar
import com.example.portalparauapebasapp.ui.theme.TopBottomAppBarColor

// Função da barra superior do App.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortalPebaAppBar() {
    // Função da barra superior que alinha tudo no centro.
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = TopBottomAppBarColor
        ),
        title = {
            Text(
                fontFamily = fontAppBar,
                text = stringResource(R.string.portal_parauapebas_appBarTex),
                fontWeight = FontWeight.SemiBold
            )
        }
    )
}