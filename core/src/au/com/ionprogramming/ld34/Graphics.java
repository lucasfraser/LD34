package au.com.ionprogramming.ld34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Lucas on 13/12/2015.
 */
public class Graphics {

    SpriteBatch titleBatch;
    SpriteBatch mainGame;
    SpriteBatch seasonalOverlay;
    SpriteBatch HUD;

    //TITLE SCREEN
    boolean titleScreen = true;
    float tint = 0;
    boolean fadeIn = true;

    public Graphics(){
        titleBatch = new SpriteBatch();
        mainGame = new SpriteBatch();
        seasonalOverlay = new SpriteBatch();
        HUD = new SpriteBatch();
        Images.loadImages();
        SeasonRendering.initSeasons();
    }

    public void draw(){
        if(titleScreen) { //TITLE SCREEN RENDERING
            if (fadeIn) {
                tint += 0.01f;
                if (tint >= 1) {
                    fadeIn = false;
                }
            }
            if (!fadeIn) {
                tint -= 0.01f;
                if (tint <= 0) {
                    titleScreen = false;
                    titleBatch.setColor(new Color(1, 1, 1, 1));
                }
            }

            titleBatch.begin();

                titleBatch.setColor(new Color(tint, tint, tint, 1));
                titleBatch.draw(Images.ion, Gdx.graphics.getWidth() / 2 - Images.ion.getWidth() / 2, Gdx.graphics.getHeight() - Images.ion.getHeight() - 50);
                titleBatch.draw(Images.lucas, Gdx.graphics.getWidth() / 2 - Images.lucas.getWidth() / 2, 50);

            titleBatch.end();
        }

        else{ //GAME RENDERING

            mainGame.begin();

            mainGame.end();

            seasonalOverlay.begin();
                SeasonRendering.renderSeasons(seasonalOverlay);
            seasonalOverlay.end();

            HUD.begin();

            HUD.end();
        }



    }
}
