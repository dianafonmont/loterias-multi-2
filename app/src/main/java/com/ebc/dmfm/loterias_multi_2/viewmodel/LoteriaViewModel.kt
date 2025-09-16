package com.ebc.dmfm.loterias_multi_2.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebc.dmfm.loterias_multi_2.network.ApiClient
import com.ebc.dmfm.loterias_multi_2.network.LoteriaMultiservice
import kotlinx.coroutines.launch



class LoteriaViewModel: ViewModel() {
    private val loteriaService = ApiClient.retrofit.create(LoteriaMultiservice::class.java)

    val isLoading = mutableStateOf(false)
    val numeros = mutableStateListOf<Int>()
    val errorMessage = mutableStateOf<String?>(null)

    fun generarNumeros() {
        viewModelScope.launch {
            isLoading.value = true
            errorMessage.value = null

            try {
                val resultado = loteriaService.generarNumeros()
                numeros.clear()
                numeros.addAll(resultado)
            } catch (e: Exception) {
                errorMessage.value = e.message ?: "Falló la generación de números"
            } finally {
                isLoading.value = false
            }
        }
    }
}