package au.com.ionprogramming.ld34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Lucas on 13/12/2015.
 */
public class Graphics {

    SpriteBatch batch;

    public Graphics(){
        batch = new SpriteBatch();
        Images.loadImages();
    }

    public void draw(){

        batch.begin();

            batch.draw(Images.ion, Gdx.graphics.getWidth() / 2 - Images.ion.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Images.ion.getHeight() / 2);

        batch.end();

    }
}
