package com.example.lbtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.lbtest.presentation.navigation.AppNavigation
import com.example.lbtest.presentation.theme.ui.LBTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LBTestTheme {
                App {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun App(content: @Composable () -> Unit) {
    content()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LBTestTheme {
        App {

        }
    }
}