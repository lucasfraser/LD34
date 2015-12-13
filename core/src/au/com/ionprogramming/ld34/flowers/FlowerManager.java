package au.com.ionprogramming.ld34.flowers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sam on 13/12/2015.
 */
public class FlowerManager {

    public static final int bedLength = 8;
    public static final int numBeds = 4;
    public static final int numStages = 6;

    //Draw offsets
    public static final int xOffset = 64;
    public static final int yOffset = 64;
    public static final int xStep = 32;
    public static final int yStep = 64;

    public static FlowerBed[] flowerBeds = new FlowerBed[numBeds];

    public static void drawBed(SpriteBatch batch, int bedIndex){
        flowerBeds[bedIndex].draw(batch, yOffset + (numBeds - bedIndex)*yStep);
    }

    public static void addFlowerBed(FlowerBed b, int bedIndex){
        flowerBeds[bedIndex] = b;
    }

    public static FlowerBed getFlowerBed(int bedIndex){
        return flowerBeds[bedIndex];
    }

    public static void addFlower(Flower f, int bedIndex, int flowerIndex){
        getFlowerBed(bedIndex).addFlower(f, flowerIndex);
    }

    public static Flower getFlower(int bedIndex, int flowerIndex){
        return getFlowerBed(bedIndex).getFlower(flowerIndex);
    }

    public static void removeFlower(int bedIndex, int flowerIndex){
        getFlowerBed(bedIndex).removeFlower(flowerIndex);
    }
}
