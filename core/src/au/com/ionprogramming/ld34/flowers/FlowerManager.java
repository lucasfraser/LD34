package au.com.ionprogramming.ld34.flowers;

import au.com.ionprogramming.ld34.Images;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sam on 13/12/2015.
 */
public class FlowerManager {

    public static final int scale = 2;

    public static final int bedLength = 6;
    public static final int numBeds = 4;

    public static final int numStages = 6;

    //Draw offsets
    public static final int xOffset = 150;
    public static final int yOffset = 100;
    public static final int xStep = 64;
    public static final int yStep = 48;

    public static final int clickRange = 16;

    public static final int iconSpeed = 10;
    public static final int iconHeight = 10;

    public static FlowerBed[] flowerBeds = new FlowerBed[numBeds];

    public static void initFlowerBeds(){
        for(int n = 0; n < numBeds; n++){
            flowerBeds[n] = new FlowerBed();
        }
    }

    public static void drawBedDirt(SpriteBatch batch){
        int imgW = Images.bedC.getWidth();
        int imgH = Images.bedC.getHeight();
        int bedWidth = bedLength*xStep;
        for(int n = 0; n < numBeds; n++){
            int y = yOffset + ((numBeds - n - 1)*yStep - imgH)*scale;
            for(int i = 0; i < (float)(bedWidth)/imgW; i++){
                int x = xOffset + (i*imgW - imgW/2)*scale;
                if(i == 0){
                    batch.draw(Images.bedL, x, y, imgW*scale, imgH*scale);
                }
                else if(i >= (int)((float)(bedWidth)/imgW) - 1){
                    batch.draw(Images.bedR, x, y, imgW*scale, imgH*scale);
                }
                else{
                    batch.draw(Images.bedC, x, y, imgW*scale, imgH*scale);
                }
            }
        }
    }

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

    public Flower getClickedFlower(int xClick, int yClick){
        int bedIndex = Math.round((float) (yClick - yOffset)/yStep);
        if(bedIndex >= 0 && bedIndex < numBeds){
            if(Math.abs(yClick - (yOffset + bedIndex*yStep*scale)) <= clickRange*scale){
                return flowerBeds[numBeds - bedIndex - 1].getClickedFlower(xClick);
            }
        }
        return null;
    }
}
