package au.com.ionprogramming.ld34;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

/**
 * Created by Sam on 13/12/2015.
 */
public class FlowerManager {

    public static final int scale = 2;

    public static final int bedLength = 10;
    public static final int numBeds = 3;

    public static final int numStages = 6;

    //Draw offsets
    public static final int xOffset = 150;
    public static final int yOffset = 140;
    public static final int xStep = 40*scale;
    public static final int yStep = 58*scale;

    public static final int clickRange = 16*scale;

    public static final int iconSpeed = 10;
    public static final int iconHeight = 0*scale;

    public static final int plantYOffset = -6*scale;

    public static FlowerBed[] flowerBeds = new FlowerBed[numBeds];

    public static Flower[] flowerTypes = new Flower[]{
            new Buttercup(),
            new Buttermug(),
            new Buttergoblet(),
            new Poppy(),
            new RoyalPoppy(),
            new OpiumPoppy(),
            new Bamboo(),
            new Bluebell(),
            new Pumpkin(),
            new Pumpkin5(),
            new HeartRose()
    };

    public static void initFlowerBeds(){
        for(int n = 0; n < numBeds; n++){
            flowerBeds[n] = new FlowerBed();
        }
    }

    public static void update(){
        for(int n = 0; n < flowerBeds.length; n++){
            flowerBeds[n].update();
        }
    }

    public static void drawBedDirt(SpriteBatch batch){
        int imgW = Images.bedC.getWidth()*scale;
        int imgH = Images.bedC.getHeight()*scale;
        int bedWidth = bedLength*xStep;
        for(int n = 0; n < numBeds; n++){
            int y = yOffset + (numBeds - n - 1)*yStep - imgH;
            int bedXOffset = -(int)((Math.ceil((float) (bedWidth) / imgW)*imgW - bedWidth)/2);
            for(int i = 0; i < Math.ceil((float) (bedWidth) / imgW); i++){
                int x = xOffset + bedXOffset + i*imgW - imgW/2;
                if(i == 0){
                    batch.draw(Images.bedL, x, y, imgW, imgH);
                }
                else if(i >= Math.ceil((float)(bedWidth)/imgW) - 1){
                    batch.draw(Images.bedR, x, y, imgW, imgH);
                }
                else{
                    batch.draw(Images.bedC, x, y, imgW, imgH);
                }
            }
        }
    }

    public static void drawBed(SpriteBatch batch, int bedIndex){
        flowerBeds[bedIndex].draw(batch, yOffset + (numBeds - bedIndex - 1)*yStep + plantYOffset);
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

    public static Flower getClickedFlower(int xClick, int yClick){
        int bedIndex = Math.round((float) (yClick - yOffset)/yStep);
        if(bedIndex >= 0 && bedIndex < numBeds){
            if(Math.abs(yClick - (yOffset + bedIndex*yStep - 20)) <= clickRange){
                return flowerBeds[numBeds - bedIndex - 1].getClickedFlower(xClick);
            }
        }
        return null;
    }

    public static Point getClickedFlowerPosition(int xClick, int yClick){
        int bedIndex = Math.round((float) (yClick - yOffset)/yStep);
        if(bedIndex >= 0 && bedIndex < numBeds){
            if(Math.abs(yClick - (yOffset + bedIndex*yStep - 20)) <= clickRange){
                int flowerIndex = flowerBeds[numBeds - bedIndex - 1].getClickedFlowerPosition(xClick);
                if(flowerIndex != -1) {
                    return new Point(numBeds - bedIndex - 1, flowerIndex);
                }
            }
        }
        return null;
    }
}
