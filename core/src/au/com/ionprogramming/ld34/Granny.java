package au.com.ionprogramming.ld34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

/**
 * Created by Sam on 14/12/2015.
 */
public class Granny {

    public static int drawPosX = 45;
    public static int drawPosY = 200;

    public static int targetX = 45;
    public static int targetY = 200;

    public static final int leftPath = 45;
    public static final int rightPath = 935;

    public static final int speed = 2;

    public static boolean movingLeft = false;
    public static boolean movingRight = false;

    public static int bedIndex = 0;
    public static int flowerIndex = 0;

    public static int purse = 5;
    public static int[] seeds = new int[FlowerManager.flowerTypes.length];
    public static int waterCapacity = 20;
    public static int water = 15;

    public static boolean headingHome = false;
    public static boolean manualTarget = false;
    public static boolean viewingMenu = false;
    public static boolean viewingSeeds = false;

    public static SpeechBubble bubble;
    public static SpeechBubble seedBubble;

    public static void setTarget(int xClick, int yClick){
        yClick = Gdx.graphics.getHeight() - yClick;
        Point p = FlowerManager.getClickedFlowerPosition(xClick, yClick);
        if(p!=null) {
            headingHome = false;
            manualTarget = false;
            targetX = FlowerManager.xOffset + p.y * FlowerManager.xStep;
            targetY = FlowerManager.yOffset + (FlowerManager.numBeds - p.x - 1) * FlowerManager.yStep;
            bedIndex = p.x;
            flowerIndex = p.y;
            String text;
            if(FlowerManager.getFlower(p.x, p.y) != null) {
                text = FlowerManager.getFlower(p.x, p.y).getName() + "\nWATER?\nPICK?\nEXIT?";
            }
            else{
                text = "PLANT SEED?\nEXIT?";
            }
            bubble = new SpeechBubble(text, 120, Color.SALMON, new Color(0f, 0f, 0f, 0.7f), 1, true);
        }
    }

    public static void generateSeedBubble(){
        viewingSeeds = true;
        String text = "";
        for(int n = 0; n < seeds.length; n++){
            if(seeds[n] > 0){
                text += "\n" + FlowerManager.flowerTypes[n].getName() + ": " + seeds[n];
            }
        }
        text += "\nEXIT?";
        seedBubble = new SpeechBubble(text, 200, Color.SALMON, new Color(0f, 0f, 0f, 0.7f), 1.5f, true);
    }

    public static void setManualTarget(int x, int y){
        targetX = x;
        targetY = y;
        manualTarget = true;
    }

    public static int getRow(){
        if(drawPosY != targetY){
            return FlowerManager.numBeds - (drawPosY - FlowerManager.yOffset)/FlowerManager.yStep - 1;
        }
        else{
            return bedIndex;
        }
    }

    public static void update(SpriteBatch batch){
        if(drawPosY != targetY){
            if(drawPosX != leftPath && drawPosX < (rightPath - leftPath)/2 + leftPath){
                drawPosX -= speed;
                movingLeft = true;
                movingRight = false;
                if(drawPosX < leftPath){
                    drawPosX = leftPath;
                }
            }
            else if(drawPosX != rightPath && drawPosX >= (rightPath - leftPath)/2 + leftPath){
                drawPosX += speed;
                movingLeft = false;
                movingRight = true;
                if(drawPosX > rightPath){
                    drawPosX = rightPath;
                }
            }
            else if(drawPosY > targetY){
                drawPosY -= speed;
                if(drawPosY < targetY){
                    drawPosY = targetY;
                }
            }
            else if(drawPosY < targetY){
                drawPosY += speed;
                if(drawPosY > targetY){
                    drawPosY = targetY;
                }
            }
        }
        else if(drawPosX != targetX){
            if(drawPosX < targetX){
                drawPosX += speed;
                movingLeft = false;
                movingRight = true;
                if(drawPosX > targetX){
                    drawPosX = targetX;
                }
            }
            else if(drawPosX > targetX){
                drawPosX -= speed;
                movingLeft = true;
                movingRight = false;
                if(drawPosX < targetX){
                    drawPosX = targetX;
                }
            }
        }
        else{
            movingLeft = false;
            movingRight = false;
        }
        draw(batch);
    }

    public static void drawBubble(SpriteBatch batch, ShapeRenderer r){
        if(!manualTarget && bubble != null && targetX == drawPosX && targetY == drawPosY){
            viewingMenu = true;
            bubble.renderWithPoint(batch, r, drawPosX - bubble.width / 2, drawPosY - 25 * FlowerManager.scale);
            if(viewingSeeds){
                viewingMenu = false;
                seedBubble.render(batch, r, Gdx.graphics.getWidth()/2 - seedBubble.width/2, Gdx.graphics.getHeight()/2 + seedBubble.height/2);
            }
        }
        else{
            viewingMenu = false;
        }
    }

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
            int flowerType;
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

    static int stage = 0;
    static int counter = 0;
    public static void draw(SpriteBatch batch){
        if(movingLeft || movingRight){
            counter ++;
            if(counter > 15){
                counter = 0;
                stage ++;
                if (stage > 3){
                    stage = 0;
                }
            }
        }
        if(movingRight) {
            batch.draw(Images.granny[stage], drawPosX, drawPosY, Images.granny[stage].getWidth() * 2, Images.granny[stage].getHeight() * 2);
        }
        else {
            batch.draw(Images.granny[stage], drawPosX, drawPosY, Images.granny[stage].getWidth() * 2, Images.granny[stage].getHeight() * 2, 0, 0, 32, 64, true, false);
        }
    }
}
