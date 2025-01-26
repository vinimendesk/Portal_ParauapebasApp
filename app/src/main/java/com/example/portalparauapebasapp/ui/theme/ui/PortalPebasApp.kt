package com.example.portalparauapebasapp.ui.theme.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.portalparauapebasapp.Greeting
import com.example.portalparauapebasapp.R
import com.example.portalparauapebasapp.ui.theme.Pink
import com.example.portalparauapebasapp.ui.theme.PinkStrong
import com.example.portalparauapebasapp.ui.theme.PortalParauapebasAppTheme

@Composable
fun PortalPebaApp () {
    Scaffold(
        topBar = { PortalPebaAppBar() }
    ) {paddingValues ->
        NewsScreen(Modifier.padding(paddingValues))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortalPebaAppBar() {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Pink
        ),
        title = {
            Text(text = stringResource(R.string.portal_parauapebas_appBarTex))
        }
    )
}

@Preview
@Composable
fun PortalPebasAppPreview() {
    PortalParauapebasAppTheme {
        PortalPebaApp()
    }
}