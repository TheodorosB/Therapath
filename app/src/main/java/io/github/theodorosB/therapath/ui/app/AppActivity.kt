package io.github.theodorosB.therapath.ui.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import io.github.theodorosB.therapath.ui.dashboard.navdisplay.DashboardNavDisplay
import io.github.theodorosB.therapath.ui.theme.TherapathTheme

@AndroidEntryPoint
class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TherapathTheme {
                DashboardNavDisplay()
            }
        }
    }
}