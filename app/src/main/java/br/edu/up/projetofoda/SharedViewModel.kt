package br.edu.up.projetofoda

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var name by mutableStateOf("")
    var phone by mutableStateOf("")
    var biotype by mutableStateOf("")
}