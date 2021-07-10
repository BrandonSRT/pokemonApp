package com.example.pokemonapp.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R


class PokeHeaderAdapter (val letterHeader: String) :RecyclerView.Adapter<PokeHeaderAdapter.PokeHeaderViewHolder>() {


    inner class PokeHeaderViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

       private val headerTextView: TextView = itemView.findViewById(R.id.headerTextView)

        fun bind(letter: String){
            headerTextView.text = letter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeHeaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_header_cell, parent, false)
        return PokeHeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokeHeaderViewHolder, position: Int) {
        holder.bind(letterHeader)
    }

    override fun getItemCount(): Int = 1


}