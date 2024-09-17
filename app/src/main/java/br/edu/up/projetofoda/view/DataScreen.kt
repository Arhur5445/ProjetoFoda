package br.edu.up.projetofoda.view


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import br.edu.up.projetofoda.SharedViewModel

@Composable
fun DataScreen(navController: NavHostController, sharedViewModel: SharedViewModel) {
    var name by rememberSaveable { mutableStateOf(sharedViewModel.name) }
    var phone by rememberSaveable { mutableStateOf(sharedViewModel.phone) }
    var biotype by rememberSaveable { mutableStateOf(sharedViewModel.biotype) }

    Column {
        OutlinedTextField(
            value = name,
            onValueChange = { newValue ->
                name = newValue
                sharedViewModel.name = newValue
            },
            label = { Text("Nome") }
        )
        OutlinedTextField(
            value = phone,
            onValueChange = { newValue ->
                phone = newValue
                sharedViewModel.phone = newValue
            },
            label = { Text("Número de telefone") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next)
        )
        OutlinedTextField(
            value = biotype,
            onValueChange = { newValue ->
                biotype = newValue
                sharedViewModel.biotype = newValue
            },
            label = { Text("Descrição do biotipo") },
            maxLines = 4
        )
        Button(onClick = {
            navController.navigate("sharing")
        }) {
            Text("Ir para Compartilhamento")
        }
    }
}
