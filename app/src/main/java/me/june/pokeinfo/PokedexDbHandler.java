package me.june.pokeinfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j8823_000 on 8/17/2016.
 */
public class PokedexDbHandler extends SQLiteOpenHelper{
    //database version
    private static final int DATABASE_VERSION = 1;

    //database name
    private static final String DATABASE_NAME = "Pokedex.db";

    //pokedex table name
    private static final String TABLE_POKEDEX = "pokedex";

    //pokedex table column names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_TYPE1 = "type1";
    private static final String KEY_TYPE2 = "type2";
    private static final String KEY_CANDY_TO_EVOLVE = "candyToEvolve";

    private static final String[] allColumn = {KEY_ID, KEY_NAME, KEY_TYPE1, KEY_TYPE2, KEY_CANDY_TO_EVOLVE};

    private Context context;

    public PokedexDbHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    //Creating database
    @Override
    public void onCreate(SQLiteDatabase db){
        final String CREATE_POKEDEX_TABLE = "CREATE TABLE " + TABLE_POKEDEX + "("
                + KEY_ID + " TEXT PRIMARY KEY,"
                + KEY_NAME + " TEXT NOT NULL,"
                + KEY_TYPE1 + " TEXT,"
                + KEY_TYPE2 + " TEXT,"
                + KEY_CANDY_TO_EVOLVE + " INTEGER" + ")";

        db.execSQL(CREATE_POKEDEX_TABLE);

        db.close();

        XMLParser parser = new XMLParser();
        Document doc = parser.getDomElement(context);

        NodeList pokemonNodeList = doc.getElementsByTagName("pokemon");

        db = this.getWritableDatabase();

        for(int i = 0; i < pokemonNodeList.getLength(); i++){
            Element e = (Element) pokemonNodeList.item(i);
            ContentValues values = new ContentValues();
            values.put(KEY_ID, parser.getValue(e, "id"));
            values.put(KEY_NAME, parser.getValue(e, "name"));
            values.put(KEY_TYPE1, parser.getValue(e, "type1"));
            values.put(KEY_TYPE2, parser.getValue(e, "type2"));
            values.put(KEY_CANDY_TO_EVOLVE, parser.getValue(e, "candyToEvolve"));
            db.insert(TABLE_POKEDEX, null, values);
        }
        db.close();

    }

    //upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(PokedexDbHandler.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy add old data");

        //Drop older version of table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POKEDEX);
        // Create new version of table
        onCreate(db);
    }

    /**
     * adding new entry to the table
     * @param pokemon pokemon you want to add
     */
    public void addPokemon(Pokemon pokemon){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, pokemon.getId());
        values.put(KEY_NAME, pokemon.getName());
        values.put(KEY_TYPE1, pokemon.getType1());
        values.put(KEY_TYPE2, pokemon.getType2());
        values.put(KEY_CANDY_TO_EVOLVE, pokemon.getCandyToEvolve());

        db.insert(TABLE_POKEDEX, null, values);
        db.close();
    }

    /**
     * retrieve the the new pokemon instance that matches the id
     * @param id id of the item you want
     * @return new pokemon object
     */
    public Pokemon getPokemon(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_POKEDEX, allColumn, KEY_ID + "=?", new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        Pokemon pokemon = new Pokemon(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                Integer.parseInt(cursor.getString(4)));

        return pokemon;
    }

    /**
     * get all the pokemons from the pokedex table
     * @return a list that contains all pokemon
     */
    public ArrayList<Pokemon> getPokedex(){
        ArrayList<Pokemon> pokedex = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_POKEDEX;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //looping through all the rows and adding to the list
        if(cursor.moveToFirst()){
            do{
                Pokemon pokemon = new Pokemon(cursor.getString(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), Integer.parseInt(cursor.getString(4)));
                pokedex.add(pokemon);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return pokedex;
    }


}
