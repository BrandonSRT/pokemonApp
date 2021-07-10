package com.example.pokemonapp.views.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.R
import com.example.pokemonapp.views.adapters.PokeHeaderAdapter
import com.example.pokemonapp.views.adapters.PokeListAdapter
import com.example.pokemonapp.views.models.PokeInformation

class PokeListFragment: Fragment (R.layout.fragment_poke_list) {

    private lateinit var pokeRecyclerView: RecyclerView

    private val adapterB = PokeListAdapter{pokeInformation ->
        val action = PokeListFragmentDirections.actionPokeListFragmentToPokeDetailFragment(pokeInformation)
        findNavController().navigate(action)
    }

    private val adapterC = PokeListAdapter{ pokeInformation ->
        val action = PokeListFragmentDirections.actionPokeListFragmentToPokeDetailFragment(pokeInformation)
        findNavController().navigate(action)

    }

    private val adapterJ = PokeListAdapter{ pokeInformation ->
        val action = PokeListFragmentDirections.actionPokeListFragmentToPokeDetailFragment(pokeInformation)
        findNavController().navigate(action)

    }

    private val adapterO = PokeListAdapter{ pokeInformation ->
        val action = PokeListFragmentDirections.actionPokeListFragmentToPokeDetailFragment(pokeInformation)
        findNavController().navigate(action)

    }

    private val adapterP = PokeListAdapter{ pokeInformation ->
        val action = PokeListFragmentDirections.actionPokeListFragmentToPokeDetailFragment(pokeInformation)
        findNavController().navigate(action)

    }

    private val adapterS = PokeListAdapter{ pokeInformation ->
        val action = PokeListFragmentDirections.actionPokeListFragmentToPokeDetailFragment(pokeInformation)
        findNavController().navigate(action)

    }

    private val concatAdapter = ConcatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        concatAdapter.addAdapter(PokeHeaderAdapter("B"))
        concatAdapter.addAdapter((adapterB))
        concatAdapter.addAdapter(PokeHeaderAdapter("C"))
        concatAdapter.addAdapter(adapterC)
        concatAdapter.addAdapter(PokeHeaderAdapter("J"))
        concatAdapter.addAdapter(adapterJ)
        concatAdapter.addAdapter(PokeHeaderAdapter("O"))
        concatAdapter.addAdapter(adapterO)
        concatAdapter.addAdapter(PokeHeaderAdapter("P"))
        concatAdapter.addAdapter(adapterP)
        concatAdapter.addAdapter(PokeHeaderAdapter("S"))
        concatAdapter.addAdapter(adapterS)

        adapterB.pokeList = getDummyPokeListB()
        adapterC.pokeList = getDummyPokeListC()
        adapterJ.pokeList = getDummyPokeListJ()
        adapterO.pokeList = getDummyPokeListO()
        adapterP.pokeList = getDummyPokeListP()
        adapterS.pokeList = getDummyPokeListS()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokeRecyclerView = view.findViewById(R.id.pokeListRecyclerView)
        pokeRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), VERTICAL))

        pokeRecyclerView.adapter = concatAdapter


    }


    private fun getDummyPokeListB(): List<PokeInformation>{
        return listOf(
            PokeInformation("Bulbasaur", "Pokémon cuadrúpedo de color verde y manchas más oscuras de formas geométricas", "https://static.wikia.nocookie.net/pokemon-super-fanon/images/4/43/Bulbasaur.png/revision/latest?cb=20151125013521&path-prefix=es"),
            PokeInformation("Butterfree", "Mariposa Pokémon atractiva que posee unos grandes ojos rojos", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/012.png"),
        )

    }

    private fun getDummyPokeListC(): List<PokeInformation>{
        return listOf(
            PokeInformation("Charmander", "Pokémon de tipo fuego introducido en la primera generación", "https://static.wikia.nocookie.net/superpokemon/images/f/f2/Charmander.jpg/revision/latest?cb=20101205152949&path-prefix=es"),
        )
    }

    private fun getDummyPokeListJ(): List<PokeInformation>{
        return listOf(
            PokeInformation("Jumpluff", "Pokémon de tipo planta/volador introducido en la segunda generación", "https://pokepedia.pro/imagenes/pokemon/jumpluff.png")
        )
    }


    private fun getDummyPokeListO(): List<PokeInformation>{
        return listOf(
            PokeInformation("Omanyte", "Pokémon fósil de tipo roca/agua introducido en la primera generación que se considera extinto", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/138.png")
        )

    }

    private fun getDummyPokeListP(): List<PokeInformation>{
        return listOf(
            PokeInformation("Psyduck", "No se acuerda nunca de haber usado su misterioso poder.", "https://i.pinimg.com/originals/35/df/47/35df47a05c5523efe91c3f4ec17d6e35.jpg"),
            PokeInformation("Ponyta", "Pokémon que participa en el espectáculo del circo de Stella", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/077.png"),
            PokeInformation("Pikachu", "Pokémon de tipo eléctrico introducido en la primera generación", "https://i.pinimg.com/originals/e9/c0/b2/e9c0b2b063134c9cb81fe09a116fd1a3.png")
        )


    }

    private fun getDummyPokeListS(): List<PokeInformation>{
        return listOf(
            PokeInformation("Skyploom", "Pokémon de tipo planta/volador introducido en la segunda generación", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/188.png")
        )
    }

}