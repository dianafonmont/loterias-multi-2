package com.ebc.dmfm.loterias_multi_2.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ebc.dmfm.loterias_multi_2.viewmodel.AdivinaViewModel

@Preview(showBackground = true)
@Composable
fun AdivinaScreen(
    navController: NavController = rememberNavController(),
    viewModel: AdivinaViewModel = AdivinaViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterVertically as Alignment.Horizontal
    ) {
        OutlinedTextField(
            value = viewModel.inputNumber.value,
            onValueChange = {
                viewModel.inputNumber.value = it
            },
            label = {
                Text(text= "Dame un numero")
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            )
        )
        viewModel.errorMessage.value?.let {
            Text(text = it, color = Color.Red)
        }
        Button(
                onClick = viewModel::verificar,
                modifier = Modifier.padding(15.dp)
                ) {
            Text(text = "Intentar")
        }
        if(viewModel.isLoading.value) {
            CircularProgressIndicator()
        }
        viewModel.resultado.value?.let {
            Text(text = it, modifier = Modifier
                .padding(top = 15.dp)
                .align (Alignment.CenterHorizontally)
            )
        }

    }

}