package me.june.pokeinfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/11.
 */
public class PokemonAdapter extends ArrayAdapter<Pokemon>{

    private static LayoutInflater inflater = null;

    public PokemonAdapter(Context context, ArrayList<Pokemon> pokemons){
        super(context, 0, pokemons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //Get the data item for this position
        Pokemon pokemon = getItem(position);

        View view = convertView;
        if(convertView == null){
            view = inflater.inflate(R.layout.pokedex_row, null);
        }

        //create view holder to hold for a row
        ViewHolder viewHolder;

        TextView pokedexId = (TextView) view.findViewById(R.id.pokedexId);
        ImageView pokedexIamge = (ImageView) view.findViewById(R.id.pokedexImage);
        TextView pokedexName = (TextView) view.findViewById(R.id.pokedexName);
        TextView pokedexType1 = (TextView) view.findViewById(R.id.pokedexType1);
        TextView pokedexType2 = (TextView) view.findViewById(R.id.pokedexType2);

        pokedexId.setText(pokemon.getId());


        return view;
    }

    public static class ViewHolder{
        TextView id;
        TextView name;
        ImageView pokemonIcon;
    }


}
