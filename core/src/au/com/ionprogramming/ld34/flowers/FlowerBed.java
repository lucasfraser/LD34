package au.com.ionprogramming.ld34.flowers;

import au.com.ionprogramming.ld34.Images;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Sam on 13/12/2015.
 */
public class FlowerBed {

    private Flower[] flowers;

    public FlowerBed(){
        flowers = new Flower[FlowerManager.bedLength];
    }

    public void draw(SpriteBatch batch, int y){
        for(int n = 0; n < FlowerManager.bedLength; n++){
            if(flowers[n] != null) {
                flowers[n].draw(batch, FlowerManager.xOffset + n*FlowerManager.xStep, y);
                if(flowers[n].getStage() == 3){
                    int imgW = Images.exc1.getWidth()*FlowerManager.scale;
                    int imgH = Images.exc1.getHeight()*FlowerManager.scale;
                    int iconX = FlowerManager.xOffset + n*FlowerManager.xStep - imgW/2;
                    int iconY = y + FlowerManager.iconHeight;
                    if(flowers[n].getTimer() < FlowerManager.iconSpeed){
                        batch.draw(Images.exc1, iconX, iconY, imgW, imgH);
                    }
                    else{
                        batch.draw(Images.exc2, iconX, iconY, imgW, imgH);
                    }
                    if(flowers[n].getTimer() < 2*FlowerManager.iconSpeed){
                        flowers[n].incTimer();
                    }
                    else{
                        flowers[n].setTimer(0);
                    }
                }
            }
        }
    }

    public void addFlower(Flower f, int flowerIndex){
        flowers[flowerIndex] = f;
    }

    public Flower getFlower(int flowerIndex){
        return flowers[flowerIndex];
    }

    public void removeFlower(int flowerIndex){
        flowers[flowerIndex] = null;
    }

    public Flower getClickedFlower(int xClick){
        int flowerIndex = Math.round((float) (xClick - FlowerManager.xOffset)/FlowerManager.xStep);
        if(flowerIndex >= 0 && flowerIndex < FlowerManager.bedLength){
            if(Math.abs(xClick - (FlowerManager.xOffset + flowerIndex*FlowerManager.xStep)) <= FlowerManager.clickRange){
                return flowers[flowerIndex];
            }
        }
        return null;
    }
}
