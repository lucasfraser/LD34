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
    static SpeechBubble name;

    public static void render(SpriteBatch batch, ShapeRenderer renderer) {
        batch.draw(Images.sbay, Gdx.graphics.getWidth() - Images.sbay.getWidth()*4 - 20, Gdx.graphics.getHeight() - Images.sbay.getHeight()*4 - 20, Images.sbay.getWidth()*4, Images.sbay.getHeight()*4);

        if(Gdx.input.justTouched() && Gdx.input.getX() > Gdx.graphics.getWidth() - Images.sbay.getWidth()*4 - 20 && Gdx.input.getX() < Gdx.graphics.getWidth() - 20 && Gdx.input.getY() > 20 && Gdx.input.getY() < 20 + Images.sbay.getHeight()*4){
            inSeedBay = true;
        }

        if(inSeedBay && Gdx.input.justTouched() && Gdx.input.getX() > 857 && Gdx.input.getX() < 882 && Gdx.input.getY() > 77 && Gdx.input.getY() < 107){
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
                Granny.buySeed(currentPlant);
            }
            batch.draw(Images.seedBayIE, Gdx.graphics.getWidth() / 2 - Images.seedBayIE.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Images.seedBayIE.getHeight() / 2);

            batch.draw(Images.buy, Gdx.graphics.getWidth() / 2 - Images.buy.getWidth() / 2, 90);
            batch.draw(Images.leftArrow, Gdx.graphics.getWidth() / 2 - Images.leftArrow.getWidth() / 2- 300, 90);
            batch.draw(Images.rightArrow, Gdx.graphics.getWidth() / 2  - Images.rightArrow.getWidth() / 2+ 300, 90);

            batch.draw(FlowerManager.flowerTypes[currentPlant].getImage(3), 280, 290, 128, 256);

            name = new SpeechBubble(FlowerManager.flowerTypes[currentPlant].getName(), 410, Color.BLACK, Color.WHITE, 3);
            name.render(batch, renderer, 420, 480);

            name = new SpeechBubble(FlowerManager.flowerTypes[currentPlant].getDescription(), 400, Color.BLACK, Color.WHITE, 1);
            name.render(batch, renderer, 420, 380);

            name = new SpeechBubble("$" + FlowerManager.flowerTypes[currentPlant].getCost() + ".00", 400, Color.RED, Color.WHITE, 3);
            name.render(batch, renderer, 280, 280);

            name = new SpeechBubble("Fully Grown Value: $" + FlowerManager.flowerTypes[currentPlant].getValue(), 400, Color.GOLD, Color.WHITE, 2);
            name.render(batch, renderer, 280, 200);

            name = new SpeechBubble("Growth Rate: " + FlowerManager.flowerTypes[currentPlant].getGrowthRate(), 400, Color.BLUE, Color.WHITE, 2);
            name.render(batch, renderer, 450, 290);

            name = new SpeechBubble("Death Rate: " + FlowerManager.flowerTypes[currentPlant].getDeathRate(), 400, Color.BLUE, Color.WHITE, 2);
            name.render(batch, renderer, 450, 250);


        }
    }
}
