package au.com.ionprogramming.ld34;

import au.com.ionprogramming.ld34.flowers.FlowerManager;
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
    boolean titleScreen = false;
    float tint = 0;
    boolean fadeIn = true;

    public Graphics(){
        titleBatch = new SpriteBatch();
        mainGame = new SpriteBatch();
        seasonalOverlay = new SpriteBatch();
        HUD = new SpriteBatch();
        Images.loadImages();
        SeasonRendering.initSeasons();
        FlowerManager.initFlowerBeds();
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
                if(SeasonRendering.season == 0){
                    mainGame.draw(Images.summberBanner, 0, 450);
                }
                else if(SeasonRendering.season == 1){

                }
                else if(SeasonRendering.season == 2){
                    mainGame.draw(Images.winterBanner, 0, 450);
                }
                else if(SeasonRendering.season == 3){

                }
                mainGame.draw(Images.grass, 0, 0);
                for(int i = 0; i < 16; i++){
                    mainGame.draw(Images.fence, i * Images.fence.getWidth()*2, 435, 64, 64);
                }
                FlowerManager.drawBedDirt(mainGame);
            mainGame.end();

            seasonalOverlay.begin();
                SeasonRendering.renderSeasons(seasonalOverlay);
            seasonalOverlay.end();

            HUD.begin();
                Seedbay.render(HUD);
            HUD.end();
        }



    }
}
