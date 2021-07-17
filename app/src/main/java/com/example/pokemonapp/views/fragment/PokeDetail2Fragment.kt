package com.example.pokemonapp.views.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.pokemonapp.R

class PokeDetail2Fragment: Fragment(R.layout.fragment_poke_detail2) {

    private val args: PokeDetailFragmentArgs by navArgs()

    private lateinit var pokeInfoTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokeInfoTextView = view.findViewById(R.id.pokeInfoTextView)
        pokeInfoTextView.text = args.poke.info
    }
}