package au.com.ionprogramming.ld34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Lucas on 13/12/2015.
 */
public class Seedbay {

    public static boolean inSeedBay = false;

    public static void render(SpriteBatch batch) {
        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.getY() > 250){
            inSeedBay = true;
        }

        if (inSeedBay) {
            batch.draw(Images.seedBayIE, Gdx.graphics.getWidth() / 2 - Images.seedBayIE.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Images.seedBayIE.getHeight() / 2);


        }
    }
}
