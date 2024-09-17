package br.edu.up.projetofoda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.edu.up.projetofoda.ui.theme.ProjetoFodaTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import br.edu.up.projetofoda.view.DataScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjetoFodaTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    val sharedViewModel: SharedViewModel = viewModel()

                    NavHost(navController = navController, startDestination = "menu") {
                        composable("menu") { MenuScreen(navController) }
                        composable("data") { DataScreen(navController, sharedViewModel) }
                        composable("sharing") { SharingScreen(navController, sharedViewModel) }
                    }
                }
            }
        }
    }
}
