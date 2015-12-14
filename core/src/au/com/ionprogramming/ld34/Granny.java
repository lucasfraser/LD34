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
    public static int waterCapacity = 20;
    public static int water = 20;

    public static void buySeed(int flowerType){
        if(purse >= FlowerManager.flowerTypes[flowerType].getCost()){
            purse -= FlowerManager.flowerTypes[flowerType].getCost();
            seeds[flowerType]++;
        }
    }

    public static void plantFlower(int flowerType){
        if(FlowerManager.getFlower(bedIndex, flowerIndex) == null && seeds[flowerType] > 0) {
            try {
                FlowerManager.addFlower(FlowerManager.flowerTypes[flowerType].getClass().newInstance(), bedIndex, flowerIndex);
            } catch (Exception e) {
                System.err.println("Unable to add flower class!");
                System.err.println(e.getStackTrace());
            }
            seeds[flowerType]--;
        }
        //TODO: Play error sound
    }

    public static void pickFlower(){
        if(FlowerManager.getFlower(bedIndex, flowerIndex) != null) {
            int flowerType = 0;
            for(flowerType = 0; flowerType < FlowerManager.flowerTypes.length; flowerType++){
                if(FlowerManager.getFlower(bedIndex, flowerIndex).getClass().equals(FlowerManager.flowerTypes[flowerType].getClass())){
                    break;
                }
            }
            if(FlowerManager.getFlower(bedIndex, flowerIndex).getStage() == 0){
                seeds[flowerType]++;
            }
            else if(FlowerManager.getFlower(bedIndex, flowerIndex).getStage() == 3){
                purse += FlowerManager.getFlower(bedIndex, flowerIndex).getValue();
            }
        }
    }

    public static void waterFlower(){
        if(water > 0) {
            FlowerManager.getFlower(bedIndex, flowerIndex).setLastWater(0);
            water--;
        }
        //TODO: Play error sound
    }

    public static void draw(SpriteBatch batch){

    }
}
