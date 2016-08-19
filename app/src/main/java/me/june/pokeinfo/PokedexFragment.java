package me.june.pokeinfo;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/20.
 */
public class PokedexFragment extends ListFragment {

    private ArrayList<Pokemon> pokedex;
    private PokemonAdapter pokemonAdapter;

    public PokedexFragment(){

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        PokedexDbHandler pokedexDbHandler = new PokedexDbHandler(getActivity().getBaseContext());
        pokedex = pokedexDbHandler.getPokedex();

        pokemonAdapter = new PokemonAdapter(getActivity(), pokedex);
        setListAdapter(pokemonAdapter);

        registerForContextMenu(getListView());

    }

}
