package com.example.pokemonapp.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.pokemonapp.R
import com.example.pokemonapp.network.models.PokeResponse
import com.example.pokemonapp.views.models.PokeInformation

class PokeList2Adapter(val onItemClicked: ((PokeResponse) -> (Unit))?=null) : RecyclerView.Adapter<PokeList2Adapter.PokeViewHolder>(){

    var pokeList: List<PokeResponse> = emptyList()
    set(value){
        field = value
        notifyDataSetChanged()

    }

    inner class PokeViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

        private var nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private var infoTextView: TextView = itemView.findViewById(R.id.infoTextView)
        private var pokeImageView: ImageView = itemView.findViewById(R.id.pokeIconImageView)

        fun bind(model: PokeResponse){
            itemView.setOnClickListener{onItemClicked?.invoke(model)}

            nameTextView.text = model.name
            infoTextView.text = model.name
            Glide.with(itemView.context).load(model.pokeImage).transform(CircleCrop()).into(pokeImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val holderView = LayoutInflater.from(parent.context).inflate(R.layout.item_user_cell, parent, false)
        return PokeViewHolder(holderView)
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        holder.bind(pokeList[position])
    }

    override fun getItemCount(): Int = 150
    //Int = pokeList.size
}