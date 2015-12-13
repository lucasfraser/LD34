package au.com.ionprogramming.ld34.flowers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sam on 13/12/2015.
 */
abstract class Flower {

    private int stage = 0;
    private int timer = 0;
    private Texture getImage(){
        return getImage(stage);
    }
    public void draw(SpriteBatch batch, int x, int y){
        int imgW = getImage().getWidth();
        int imgH = getImage().getHeight();
        batch.draw(getImage(), x - imgW/2*FlowerManager.scale, y - imgH/2*FlowerManager.scale, imgW*FlowerManager.scale, imgH*FlowerManager.scale);
    }
    public void setStage(int stage){
        this.stage = stage;
    }
    public int getStage(){
        return stage;
    }
    public void setTimer(int timer){
        this.timer = timer;
    }
    public int getTimer(){
        return timer;
    }
    public void incTimer(){
        timer++;
    }

    public abstract String getName();
    public abstract String getDescription();
    public abstract Texture getImage(int imageIndex);
    public abstract int getGrowthRate();
    public abstract int getDeathRate();
    public abstract int getCost();
    public abstract int getValue();
}

class FlowerName extends Flower {

    static String name = "FlowerName";
    static String description = "The " + name + "is a blah blah with blah.";
    static int growthRate = 1;
    static int deathRate = 1;
    static int cost = 1;
    static int value = 1;
    static Texture[] images = new Texture[FlowerManager.numStages];

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Texture getImage(int imageIndex){
        return images[imageIndex];
    }
    public int getGrowthRate(){
        return growthRate;
    }
    public int getDeathRate(){
        return deathRate;
    }
    public int getCost(){
        return cost;
    }
    public int getValue(){
        return value;
    }
}
