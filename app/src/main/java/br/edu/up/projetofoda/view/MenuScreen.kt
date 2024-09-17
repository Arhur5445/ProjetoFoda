package br.edu.up.projetofoda

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.NavHostController

@Composable
fun MenuScreen(navController: NavHostController) {
    // Simulação de dados preenchidos. Substitua com lógica real.
    var isDataFilled by rememberSaveable { mutableStateOf(false) }

    // Lógica para verificar se os dados foram preenchidos
    // Aqui você deve implementar a verificação real
    // isDataFilled = checkIfDataIsFilled()

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = { navController.navigate("data") }) {
            Text("Dados")
        }
        Button(
            onClick = { navController.navigate("sharing") },
            enabled = isDataFilled
        ) {
            Text("Compartilhamento")
        }
    }
}
