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
                    mainGame.draw(Images.summerBanner, 0, 450);
                }
                else if(SeasonRendering.season == 1){
                    mainGame.draw(Images.autumnBanner, 0, 450);
                }
                else if(SeasonRendering.season == 2){
                    mainGame.draw(Images.winterBanner, 0, 450);
                }
                else if(SeasonRendering.season == 3){
                    mainGame.draw(Images.springBanner, 0, 450);
                }
                mainGame.draw(Images.grass, 0, 0);
                for(int i = 0; i < 16; i++){
                    mainGame.draw(Images.fence, i * Images.fence.getWidth()*2, 435, 64, 64);
                }
                FlowerManager.drawBedDirt(mainGame);
                for(int n = 0; n < FlowerManager.numBeds; n++) {
                    FlowerManager.drawBed(mainGame, n);
                }
            mainGame.end();

            seasonalOverlay.begin();
                SeasonRendering.renderSeasons(seasonalOverlay);
            seasonalOverlay.end();

            HUD.begin();
                HUD.draw(Images.seasonDisplay, Gdx.graphics.getWidth() / 2 - Images.seasonDisplay.getWidth() / 2, Gdx.graphics.getHeight() - Images.seasonDisplay.getHeight() / 2 - 20);
                Seedbay.render(HUD);
//
//                System.out.println(Gdx.input.getX() + ", " + Gdx.input.getY());

                if(SeasonRendering.season == 0){
                    HUD.draw(Images.selectionSeasons, 240, Gdx.graphics.getHeight() - 34);
                }
                else if(SeasonRendering.season == 1){
                    HUD.draw(Images.selectionSeasons, 380, Gdx.graphics.getHeight() - 34);
                }
                else if(SeasonRendering.season == 2){
                    HUD.draw(Images.selectionSeasons, 513, Gdx.graphics.getHeight() - 34); //513
                }
                else if(SeasonRendering.season == 3){
                    HUD.draw(Images.selectionSeasons, 641, Gdx.graphics.getHeight() - 34);
                }

                HUD.draw(Images.dayDisplay, Gdx.graphics.getWidth() / 2 - Images.dayDisplay.getWidth() / 2, Gdx.graphics.getHeight() - Images.dayDisplay.getHeight() / 2 - 55);

                if(SeasonRendering.day == 0){
                    HUD.draw(Images.selectionDays, 239, Gdx.graphics.getHeight() - 69);
                }
                else if(SeasonRendering.day == 1){
                    HUD.draw(Images.selectionDays, 320, Gdx.graphics.getHeight() - 69);
                }
                else if(SeasonRendering.day == 2){
                    HUD.draw(Images.selectionDays, 399, Gdx.graphics.getHeight() - 69);
                }
                else if(SeasonRendering.day == 3){
                    HUD.draw(Images.selectionDays, 480, Gdx.graphics.getHeight() - 69);
                }
                else if(SeasonRendering.day == 4){
                    HUD.draw(Images.selectionDays, 555, Gdx.graphics.getHeight() - 69);
                }
                else if(SeasonRendering.day == 5){
                    HUD.draw(Images.selectionDays, 621, Gdx.graphics.getHeight() - 69);
                }
                else if(SeasonRendering.day == 6){
                    HUD.draw(Images.selectionDays, 693, Gdx.graphics.getHeight() - 69);
                }
            HUD.end();
        }
    }
}
