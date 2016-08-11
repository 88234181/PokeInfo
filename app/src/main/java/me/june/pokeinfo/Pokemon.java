package me.june.pokeinfo;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class Pokemon {
    private int id;
    private String name;
    private int candyToEvolve;
    private List<Skills> possibleSkills;

    public Pokemon(int id, String name, int candyToEvolve, List<Skills> possibleSkills){
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

    public int getCandyToEvolve(){
        return candyToEvolve;
    }

    public List<Skills> getPossibleSkills(){
        return possibleSkills;
    }
}
