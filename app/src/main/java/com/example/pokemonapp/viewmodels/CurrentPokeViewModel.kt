package com.example.pokemonapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokemonapp.network.RetrofitProvider
import com.example.pokemonapp.network.models.PokeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentPokeViewModel: ViewModel() {
    private val retrofitProvider = RetrofitProvider()

    private val _currentPokeLiveData = MutableLiveData<PokeResponse>()

    val currentPokeLiveData: LiveData<PokeResponse> = _currentPokeLiveData

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _serverError = MutableLiveData<Boolean>()
    val serverError: LiveData<Boolean> = _serverError

    fun fetchCurrentPokeData(id: Int) {
        _isLoading.postValue(true)
        retrofitProvider.getApiService()
            .getPokemon(id, 150)
            .enqueue(object : Callback<PokeResponse> {
                override fun onResponse(
                    call: Call<PokeResponse>,
                    response: Response<PokeResponse>
                ) {
                    _isLoading.postValue(false)
                    if (response.isSuccessful){
                        _currentPokeLiveData.postValue(response.body())
                    }else{
                        _serverError.postValue(true)
                        //Servidor falla, por varias razones, por ejemplo, no se armo bien el request
                    }
                }

                override fun onFailure(call: Call<PokeResponse>, t: Throwable) {
                    // Servidor falla, no se pudo conectar
                    _isLoading.postValue(false)
                    _serverError.postValue(true)
                    val a = ""
                }

            })
    }
}