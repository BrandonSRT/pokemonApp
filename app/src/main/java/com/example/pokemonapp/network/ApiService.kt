package com.example.pokemonapp.network

import com.example.pokemonapp.network.models.PokeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("pokemon")
    fun getPokemon(@Query("limit") limit:Int, @Query("offset") offset:Int): Call<PokeResponse>

}