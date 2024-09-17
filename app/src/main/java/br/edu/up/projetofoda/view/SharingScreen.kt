package br.edu.up.projetofoda

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun SharingScreen(navController: NavHostController, sharedViewModel: SharedViewModel) {
    val context = LocalContext.current
    val isConnected = isInternetAvailable(context)

    var intention by rememberSaveable { mutableStateOf("") }
    var isShareEnabled by remember { mutableStateOf(false) }

    LaunchedEffect(intention) {
        isShareEnabled = intention.isNotBlank() && isConnected
    }

    Column {
        Text("Nome: ${sharedViewModel.name}")
        Text("Número de telefone: ${sharedViewModel.phone}")
        Text("Descrição do biotipo: ${sharedViewModel.biotype}")
        OutlinedTextField(
            value = intention,
            onValueChange = { intention = it },
            label = { Text("Intenção") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done)
        )
        Button(
            onClick = {
                if (isShareEnabled) {
                    shareData(context, sharedViewModel.name, sharedViewModel.phone, sharedViewModel.biotype, intention)
                }
            },
            enabled = isShareEnabled
        ) {
            Text("Compartilhar")
        }
        if (!isConnected) {
            Text("Sem conexão com a internet.", color = MaterialTheme.colorScheme.error)
        }
    }
}

private fun shareData(context: Context, name: String, phone: String, biotype: String, intention: String) {
    val shareIntent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "Nome: $name\nNúmero de telefone: $phone\nDescrição do biotipo: $biotype\nIntenção: $intention")
        type = "text/plain"
    }
    context.startActivity(Intent.createChooser(shareIntent, null))
}

private fun isInternetAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
    return networkCapabilities != null &&
            (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
}
