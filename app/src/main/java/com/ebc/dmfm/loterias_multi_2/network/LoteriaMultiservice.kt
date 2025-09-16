package com.ebc.dmfm.loterias_multi_2.network

import retrofit2.http.GET
import retrofit2.http.Query

//https://loteriasvarias.onrender.com/loteria
interface LoteriaMultiservice {
@GET("loteria")
suspend fun generarNumeros() : List<Int>
//https://loteriasvarias.onrender.com/adivina?intento=1
@GET("adivina")
suspend fun verificarIntento(@Query("intento")intento:Int)
//https://loteriasvarias.onrender.com/horoscopo?signo=12
@GET("horoscopo")
suspend fun obtenerHoroscopo(@Query("signo")signo:Int)
}