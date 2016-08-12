package me.june.pokeinfo;

import android.content.Context;
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

    public PokemonAdapter(Context context, ArrayList<Pokemon> pokemons){
        super(context, 0, pokemons);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Pokemon pokemon = getItem(position);

        return convertView;
    }

    public static class ViewHolder{
        TextView id;
        TextView name;
        ImageView pokemonIcon;
    }


}
