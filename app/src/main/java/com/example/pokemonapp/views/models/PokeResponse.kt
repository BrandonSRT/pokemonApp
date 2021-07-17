package com.example.pokemonapp.views.models

import android.os.Parcel
import android.os.Parcelable
import com.example.pokemonapp.network.models.PokeDetail

data class PokeResponse (
    val id: Int,
    val name: String,
    val pokeImage: String

): Parcelable{
    constructor(parcel: Parcel) : this(
        (parcel.readInt() ?: "") as Int,
        parcel.readString() ?: "",
        parcel.readString() ?:""
    ){

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(name)
        parcel.writeString(pokeImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokeResponse> {
        override fun createFromParcel(parcel: Parcel): PokeResponse {
            return PokeResponse(parcel)
        }

        override fun newArray(size: Int): Array<PokeResponse?> {
            return arrayOfNulls(size)
        }
    }
}