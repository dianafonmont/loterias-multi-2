package com.ebc.dmfm.loterias_multi_2.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebc.dmfm.loterias_multi_2.network.ApiClient
import com.ebc.dmfm.loterias_multi_2.network.LoteriaMultiservice
import kotlinx.coroutines.launch
import java.sql.SQLException

class AdivinaViewModel: ViewModel() {
    private val adivinaService = ApiClient.retrofit.create(LoteriaMultiservice::class.java)
    val isLoading = mutableStateOf(false)
    val inputNumber = mutableStateOf("")
    val resultado = mutableStateOf<String?>(null)
    val errorMessage = mutableStateOf<String?>(null)

    fun verificar() {
        val numero = inputNumber.value.toIntOrNull()

        if (numero == null) {
            errorMessage.value = "Ingresa un valor correcto (0-10)"
            return
        }
        viewModelScope.launch {
            isLoading.value = true
            errorMessage.value = null

            try {
                val resNum = adivinaService.verificarIntento(numero)
                resultado.value = resNum.toString()
            } catch (e: SQLException) {
                errorMessage.value = e.message ?: "Hubo un fallo de sql"
            } catch (e2: Exception) {
                errorMessage.value = e2.message ?: "Falló algo y no sé que es"
            } finally {
                isLoading.value = false
            }
        }
    }
}
