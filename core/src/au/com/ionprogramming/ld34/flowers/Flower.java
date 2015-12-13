package au.com.ionprogramming.ld34.flowers;

import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by Sam on 13/12/2015.
 */
public abstract class Flower {

    String name;
    int growthRate;
    int deathRate;
    int cost;
    int value;
    Image[] images = new Image[5];

    public abstract String getName();
    public abstract String getDesc();
}
