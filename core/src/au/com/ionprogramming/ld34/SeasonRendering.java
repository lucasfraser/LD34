package au.com.ionprogramming.ld34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Lucas on 13/12/2015.
 */
public class SeasonRendering {

    static int season = 2;     //0 - Summer, 1 - Autumn, 2 - Winter, 3 - Spring

    static Random r = new Random();

    static ArrayList<Leaf> leaves = new ArrayList<Leaf>();
    static ArrayList<Snow> snow = new ArrayList<Snow>();


    public static void initSeasons(){
        for(int i = 0; i < 20; i++) {
            leaves.add(new Leaf());
            leaves.get(i).y = r.nextInt(Gdx.graphics.getHeight());
        }
        for(int i = 0; i < 30; i++) {
            snow.add(new Snow());
            snow.get(i).y = r.nextInt(Gdx.graphics.getHeight());
        }
    }
    public static void renderSeasons(SpriteBatch batch){

        if(season == 0){

        }
        else if(season == 1){
            for(int i = 0; i < leaves.size(); i++) {
                batch.draw(Images.leaf, leaves.get(i).x, leaves.get(i).y, 5, 5, 10, 10, 1, 1, leaves.get(i).rot, 0, 0, 10, 10, false, false);
                leaves.get(i).move();
            }
        }
        else if(season == 2){
            for(int i = 0; i < snow.size(); i++) {
                batch.draw(Images.snow, snow.get(i).x, snow.get(i).y, 5, 5, 10, 10, 1, 1, snow.get(i).rot, 0, 0, 10, 10, false, false);
                snow.get(i).move();
            }
        }
        else if(season == 3){

        }
    }

    public static class Leaf{
        float x = r.nextInt(Gdx.graphics.getWidth());
        float y = Gdx.graphics.getHeight() + 20;
        float speed = (r.nextInt(3)+3) / 2f;
        int rot = r.nextInt(360);

        public void move(){
            y -= speed;

            if (y <= -10){
                x = r.nextInt(Gdx.graphics.getWidth());
                y = Gdx.graphics.getHeight() + 20;
            }

            rot += speed*4;

            if(rot > 359){
                rot = 0;
            }
        }

    }

    public static class Snow{
        float x = r.nextInt(Gdx.graphics.getWidth());
        float y = Gdx.graphics.getHeight() + 20;
        float speed = (r.nextInt(3)+2) / 2f;
        int rot = r.nextInt(360);

        public void move(){
            y -= speed;

            if (y <= -10){
                x = r.nextInt(Gdx.graphics.getWidth());
                y = Gdx.graphics.getHeight() + 20;
            }

            rot += speed*4;

            if(rot > 359){
                rot = 0;
            }
        }

    }
}
