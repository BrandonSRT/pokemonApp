package com.example.pokemonapp.views.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.viewmodels.CurrentPokeViewModel
import com.example.pokemonapp.views.adapters.PokeHeaderAdapter
import com.example.pokemonapp.views.adapters.PokeList2Adapter
import com.example.pokemonapp.views.adapters.PokeListAdapter
import com.example.pokemonapp.views.models.PokeInformation
import com.squareup.picasso.Picasso

class PokeList2Fragment: Fragment (R.layout.fragment_poke_list2) {

    private lateinit var pokeRecyclerView: RecyclerView
    private lateinit var viewModel: CurrentPokeViewModel

    private val adapter = PokeList2Adapter{pokeResponse ->
        val action = PokeList2FragmentDirections.actionPokeList2FragmentToPokeDetail2Fragment(pokeResponse)
        findNavController().navigate(action)
    }


    private val concatAdapter = ConcatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // concatAdapter.addAdapter(PokeHeaderAdapter("B"))
      //  concatAdapter.addAdapter((adapter))

        viewModel = ViewModelProvider(this).get(CurrentPokeViewModel::class.java)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokeRecyclerView = view.findViewById(R.id.pokeListRecyclerView)
        pokeRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))

        pokeRecyclerView.adapter = concatAdapter

        viewModel.currentPokeLiveData.observe(viewLifecycleOwner){

            viewModel.fetchCurrentPokeData(id)

            adapter.pokeList = it.pokemon

          //  Picasso.get()
            //    .load("")
              //  .into()

        }


    }





}