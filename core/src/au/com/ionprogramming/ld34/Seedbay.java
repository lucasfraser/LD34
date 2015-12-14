package au.com.ionprogramming.ld34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Align;

/**
 * Created by Lucas on 13/12/2015.
 */
public class Seedbay {

    public static boolean inSeedBay = false;

    static int currentPlant = 0;

    public static void render(SpriteBatch batch) {
        batch.draw(Images.sbay, Gdx.graphics.getWidth() - Images.sbay.getWidth()*4 - 20, Gdx.graphics.getHeight() - Images.sbay.getHeight()*4 - 20, Images.sbay.getWidth()*4, Images.sbay.getHeight()*4);

        if(Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.getX() > Gdx.graphics.getWidth() - Images.sbay.getWidth()*4 - 20 && Gdx.input.getX() < Gdx.graphics.getWidth() - 20 && Gdx.input.getY() > 20 && Gdx.input.getY() < 20 + Images.sbay.getHeight()*4){
            inSeedBay = true;
        }

        if(inSeedBay && Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Gdx.input.getX() > 857 && Gdx.input.getX() < 882 && Gdx.input.getY() > 77 && Gdx.input.getY() < 107){
            inSeedBay = false;
        }

        if (inSeedBay) {
            if(Gdx.input.justTouched() && Gdx.input.getX() > 150 && Gdx.input.getX() < 250 && Gdx.input.getY() > 450 && Gdx.input.getY() < 510){//Left arrow
                if(currentPlant > 0) {
                    currentPlant--;
                }
            }
            if(Gdx.input.justTouched() && Gdx.input.getX() > 750 && Gdx.input.getX() < 850 && Gdx.input.getY() > 450 && Gdx.input.getY() < 510){//Right arrow
                if(currentPlant < FlowerManager.flowerTypes.length - 1) {
                    currentPlant++;
                }
            }
            if(Gdx.input.justTouched() && Gdx.input.getX() > 450 && Gdx.input.getX() < 550 && Gdx.input.getY() > 450 && Gdx.input.getY() < 510){//Buy

            }
            batch.draw(Images.seedBayIE, Gdx.graphics.getWidth() / 2 - Images.seedBayIE.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Images.seedBayIE.getHeight() / 2);

            batch.draw(Images.buy, Gdx.graphics.getWidth() / 2 - Images.buy.getWidth() / 2, 90);
            batch.draw(Images.leftArrow, Gdx.graphics.getWidth() / 2 - Images.leftArrow.getWidth() / 2- 300, 90);
            batch.draw(Images.rightArrow, Gdx.graphics.getWidth() / 2  - Images.rightArrow.getWidth() / 2+ 300, 90);

            batch.draw(FlowerManager.flowerTypes[currentPlant].getImage(3), 280, 300, 128, 256);

            SpeechBubble name = new SpeechBubble(FlowerManager.flowerTypes[currentPlant].getName(), 410, Color.BLACK, Color.WHITE, 3);
            name.render(batch, new ShapeRenderer(), 400, 430);

            name = new SpeechBubble(FlowerManager.flowerTypes[currentPlant].getDescription(), 400, Color.BLACK, Color.WHITE, 1);
            name.render(batch, new ShapeRenderer(), 400, 380);
        }
    }
}
