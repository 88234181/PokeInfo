package me.june.pokeinfo;

import java.util.List;

/**
 * Created by Administrator on 2016/8/10.
 */
public class Skills {
    private String name;
    private String type;
    private int damage;
    private int energyIncrease;
    private float duration;
    private List<Pokemon> knownBy;

    public Skills(String name, String type, int damage, int energyIncrease, float duration, List<Pokemon> knownBy){
        this.name =  name;
        this.type = type;
        this.damage = damage;
        this.energyIncrease = energyIncrease;
        this.duration = duration;
        this.knownBy = knownBy;
    }
}
