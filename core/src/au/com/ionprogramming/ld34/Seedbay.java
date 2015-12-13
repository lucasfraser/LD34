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
        batch.draw(Images.sbay, Gdx.graphics.getWidth() - Images.sbay.getWidth()*4 - 20, Gdx.graphics.getHeight() - Images.sbay.getHeight()*4 - 20, Images.sbay.getWidth()*4, Images.sbay.getHeight()*4);

        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.getX() > Gdx.graphics.getWidth() - Images.sbay.getWidth()*4 - 20 && Gdx.input.getX() < Gdx.graphics.getWidth() - 20 && Gdx.input.getY() > 20 && Gdx.input.getY() < 20 + Images.sbay.getHeight()*4){
            inSeedBay = true;
        }

        if(inSeedBay && Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.getX() > 857 && Gdx.input.getX() < 882 && Gdx.input.getY() > 77 && Gdx.input.getY() < 107){
            inSeedBay = false;
        }

        if (inSeedBay) {
            batch.draw(Images.seedBayIE, Gdx.graphics.getWidth() / 2 - Images.seedBayIE.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Images.seedBayIE.getHeight() / 2);


        }
    }
}
