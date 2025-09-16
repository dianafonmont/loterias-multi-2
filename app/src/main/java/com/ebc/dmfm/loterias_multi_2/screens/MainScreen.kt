
package com.ebc.dmfm.loterias_multi_2.screens
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ebc.dmfm.loterias_multi_2.R

@Preview(showBackground  = true)
@Composable
fun MainScreen(navController: NavController = rememberNavController()) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            GameOption(
                idRaw = R.raw.lottie_loteria,
                label = "Loteria",
                onClick = {
                    navController.navigate("loteria")
                }
            )
            GameOption(
                idRaw = R.raw.lottie_adivina,
                label = "Adivina",
                onClick = {
                    navController.navigate("adivina")
                }
            )
            GameOption(
                idRaw = R.raw.lottie_horoscopo,
                label = "Horoscopo",
                onClick = {
                    navController.navigate("horoscopo")
                }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GameOption(
    idRaw: Int = R.raw.lottie_loteria,
    label: String = "Opcion",
    onClick: () -> Unit = {}
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(idRaw)
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(150.dp)
        )

        Text(
            text = label,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 10.dp)

        )
    }
}