package me.june.pokeinfo;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2016/8/11.
 */
public class PokemonAdapter extends ArrayAdapter<Pokemon>{

    public PokemonAdapter(Context context, ArrayList<Pokemon> pokemons){
        super(context, 0, pokemons);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        //Get the data item for this position
        Pokemon pokemon = getItem(position);

        //create view holder to hold for a row
        ViewHolder viewHolder;

        View rowView = LayoutInflater.from(getContext()).inflate(R.layout.pokedex_row, parent, true);

        return view;
    }

    public static class ViewHolder{
        TextView id;
        TextView name;
        ImageView pokemonIcon;
    }


}
