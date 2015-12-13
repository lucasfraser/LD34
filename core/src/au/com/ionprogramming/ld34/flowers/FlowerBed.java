package au.com.ionprogramming.ld34.flowers;

/**
 * Created by Sam on 13/12/2015.
 */
public class FlowerBed {

    private Flower[] flowers;

    public FlowerBed(){
        flowers = new Flower[FlowerManager.bedLength];
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
