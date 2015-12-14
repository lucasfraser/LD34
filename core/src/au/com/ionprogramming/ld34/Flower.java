package au.com.ionprogramming.ld34;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sam on 13/12/2015.
 */
abstract class Flower {

    private int lastWater = 0;
    private int stageTime = 0;
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
    public void update(){
        lastWater++;
        stageTime++;
        if(lastWater > getDeathRate()){
            if(stage == 3){
                stage = 4;
            }
            else if(stage > 0){
                stage = 5;
            }
        }
        else if(stageTime >= getGrowthRate()){
            if(stage < 3){
                stage++;
            }
            else if(stage == 4){
                stage = 3;
            }
        }
    }
    public void setLastWater(int lastWater){
        this.lastWater = lastWater;
    }
    public int getLastWater(){
        return lastWater;
    }
    public void setStageTime(int stageTime){
        this.stageTime = stageTime;
    }
    public int getStageTime(){
        return stageTime;
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

class Buttercup extends Flower {

    static String name = "Buttercup";
    static String description = "The " + name + " is a quaint treasure, often overlooked. May the yellow bring joy to your day.";
    static int growthRate = 1;
    static int deathRate = 1;
    static int cost = 1;
    static int value = 2;
    static Texture[] images = Images.flower1;

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

class Buttermug extends Flower {

    static String name = "Buttermug";
    static String description = "The " + name + " is the buttercup's more extravagant cousin.";
    static int growthRate = 1;
    static int deathRate = 1;
    static int cost = 5;
    static int value = 8;
    static Texture[] images = Images.flower1;

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

class Buttergoblet extends Flower {

    static String name = "Buttergoblet";
    static String description = "The " + name + " is the most golden and glorious of the buttercup family.";
    static int growthRate = 1;
    static int deathRate = 1;
    static int cost = 12;
    static int value = 25;
    static Texture[] images = Images.flower1;

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

class Poppy extends Flower {

    static String name = "Poppy";
    static String description = "The " + name + " displays beautiful shades of red.";
    static int growthRate = 2;
    static int deathRate = 2;
    static int cost = 3;
    static int value = 6;
    static Texture[] images = Images.flower2;

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

class RoyalPoppy extends Flower {

    static String name = "Royal Poppy";
    static String description = "The " + name + " exhibits deep, rich shades of red. A must-have in any avid grower's collection.";
    static int growthRate = 2;
    static int deathRate = 1;
    static int cost = 8;
    static int value = 15;
    static Texture[] images = Images.flower2;

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

class OpiumPoppy extends Flower {

    static String name = "Opium Poppy";
    static String description = "The " + name + ", perfect for sale on the floral black market.";
    static int growthRate = 2;
    static int deathRate = 2;
    static int cost = 20;
    static int value = 40;
    static Texture[] images = Images.flower2;

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

class Bamboo extends Flower {

    static String name = "Bamboo";
    static String description = "The " + name + " plant, the perfect way to coax pandas into your garden.";
    static int growthRate = 1;
    static int deathRate = 3;
    static int cost = 7;
    static int value = 10;
    static Texture[] images = Images.flower3;

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

class Bluebell extends Flower {

    static String name = "Bluebell";
    static String description = "The " + name + " plant, a stunning addition to any green-thumb's flower bed.";
    static int growthRate = 4;
    static int deathRate = 2;
    static int cost = 13;
    static int value = 20;
    static Texture[] images = Images.flower4;

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

class Pumpkin extends Flower {

    static String name = "Pumpkin";
    static String description = "The " + name + " is an all time favourite. Slow growing, but yields a marvellous orange behemoth of a vegetable. Be sure to pick them before they rot.";
    static int growthRate = 5;
    static int deathRate = 1;
    static int cost = 10;
    static int value = 20;
    static Texture[] images = Images.flower5;

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

class Pumpkin5 extends Flower {

    static String name = "Fifth Generation Purebred Pumpkin";
    static String description = "The " + name + " is a superb cultivar of Cucurbita. The slow growth rate is made up for by the quality of the vegetable. Be sure to pick them before they rot.";
    static int growthRate = 5;
    static int deathRate = 1;
    static int cost = 100;
    static int value = 150;
    static Texture[] images = Images.flower5;

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

class HeartRose extends Flower {

    static String name = "Heart Rose";
    static String description = "The " + name + " is the perfect gift for that special someone.";
    static int growthRate = 3;
    static int deathRate = 1;
    static int cost = 75;
    static int value = 100;
    static Texture[] images = Images.flower6;

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