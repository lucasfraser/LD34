package au.com.ionprogramming.ld34.flowers;

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
                flowers[n].draw(batch,FlowerManager.xOffset + n*FlowerManager.xStep ,y);
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
}
