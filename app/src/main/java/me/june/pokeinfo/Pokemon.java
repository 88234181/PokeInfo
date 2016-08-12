package me.june.pokeinfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class Pokemon {
    private int id;
    private String name;
    private String candyToEvolve;
    private ArrayList<Skills> possibleSkills;

    public Pokemon(int id, String name, String candyToEvolve, ArrayList<Skills> possibleSkills){
        this.id = id;
        this.name = name;
        this.candyToEvolve = candyToEvolve;
        this.possibleSkills = possibleSkills;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCandyToEvolve(){
        return candyToEvolve;
    }

    public ArrayList<Skills> getPossibleSkills(){
        return possibleSkills;
    }
}
