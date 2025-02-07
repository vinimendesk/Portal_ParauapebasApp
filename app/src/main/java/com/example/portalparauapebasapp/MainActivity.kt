package com.example.portalparauapebasapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.portalparauapebasapp.ui.PortalPebaApp
import com.example.portalparauapebasapp.ui.theme.PortalParauapebasAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PortalParauapebasAppTheme {
                PortalPebaApp()
            }
        }
    }
}