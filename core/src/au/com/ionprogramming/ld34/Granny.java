package au.com.ionprogramming.ld34;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sam on 14/12/2015.
 */
public class Granny {

    public static int drawPosX = 0;
    public static int drawPosY = 0;

    public static int bedIndex = 0;
    public static int flowerIndex = 0;

    public static int purse = 0;
    public static int[] seeds = new int[FlowerManager.flowerTypes.length];

    public static void plantFlower(int flowerType){
        if(FlowerManager.getFlower(bedIndex, flowerIndex) == null) {
            try {
                FlowerManager.addFlower(FlowerManager.flowerTypes[flowerType].getClass().newInstance(), bedIndex, flowerIndex);
            } catch (Exception e) {
                System.err.println("Unable to add flower class!");
                System.err.println(e.getStackTrace());
            }
        }
    }

    public static void waterFlower(){
        FlowerManager.getFlower(bedIndex, flowerIndex).setLastWater(0);
    }

    public static void draw(SpriteBatch batch){

    }
}
