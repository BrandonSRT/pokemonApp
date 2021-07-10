package com.example.pokemonapp.views.models

import android.os.Parcel
import android.os.Parcelable

data class PokeInformation (val name: String, val info: String, val imageUrl: String): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?:""
    ){

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(info)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokeInformation> {
        override fun createFromParcel(parcel: Parcel): PokeInformation {
            return PokeInformation(parcel)
        }

        override fun newArray(size: Int): Array<PokeInformation?> {
            return arrayOfNulls(size)
        }
    }
}
