package au.com.ionprogramming.ld34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Lucas on 13/12/2015.
 */
public class Graphics {

    SpriteBatch titleBatch;
    SpriteBatch mainGame;
    SpriteBatch seasonalOverlay;
    SpriteBatch HUD;
    ShapeRenderer renderer;

    //TITLE SCREEN
    boolean titleScreen = true;
    boolean nameShown = false;
    float tint = 0;
    boolean fadeIn = true;

    float fadeOut = 1;

    static boolean nextDayGo = false;
    static boolean nextDayCome = false;
    static boolean black = false;

    static SpeechBubble purse;


    public Graphics(){
        titleBatch = new SpriteBatch();
        mainGame = new SpriteBatch();
        seasonalOverlay = new SpriteBatch();
        HUD = new SpriteBatch();
        renderer = new ShapeRenderer();
        Images.loadImages();
        SeasonRendering.initSeasons();
        FlowerManager.initFlowerBeds();
        MusicManger.loadMusic();
    }
    public static void nextDay(){
        if(!nextDayGo && !nextDayCome) {
            nextDayGo = true;
            Seedbay.inSeedBay = false;
        }
    }

    public static void toggleNextDay(){

        SeasonRendering.day ++;
        if (SeasonRendering.day > 6){
            SeasonRendering.day = 0;
            SeasonRendering.season++;
            if(SeasonRendering.season>3){
                SeasonRendering.season = 0;
            }
            MusicManger.updateMusic();
        }
        Granny.water = Granny.waterCapacity;
    }

    int nameCount = 0;
    public void draw(){

        if(nextDayGo){
            fadeOut -= 0.01f;
            if(fadeOut <= 0){
                fadeOut = 0;
                black = true;
                nextDayGo = false;
            }
        }
        if(nextDayCome){
            fadeOut += 0.01f;
            if(fadeOut >= 1){
                fadeOut = 1;
                nextDayCome = false;
            }
        }

        if(black){
            black = false;
            toggleNextDay();
            FlowerManager.update();
            nextDayCome = true;
        }

        if(Gdx.input.justTouched() && Gdx.input.getX() > 70 && Gdx.input.getX() < 115 && Gdx.input.getY() > 120 &&Gdx.input.getY() < 205){ //70 205  --  115 120
            Granny.headingHome = true;
            Granny.setManualTarget(45, 390);
        }

        if(Granny.drawPosX == 45 && Granny.drawPosY == 390 && Granny.headingHome){
            Granny.headingHome = false;
            nextDay();
        }

        mainGame.setColor(fadeOut, fadeOut, fadeOut, 1);
        seasonalOverlay.setColor(fadeOut, fadeOut, fadeOut, 1);
        HUD.setColor(fadeOut, fadeOut, fadeOut, 1);
        renderer.setColor(fadeOut,fadeOut,fadeOut,1);

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
                titleBatch.draw(Images.sam, Gdx.graphics.getWidth() / 2 - Images.sam.getWidth() / 2, 50);
                titleBatch.draw(Images.poppy, Gdx.graphics.getWidth() / 2 - Images.poppy.getWidth() / 2+200, 50);
                titleBatch.draw(Images.lucas, Gdx.graphics.getWidth() / 2 - Images.lucas.getWidth() / 2 - 200, 50);

            titleBatch.end();
        }

        else{ //GAME RENDERING


            if(!nameShown){
                nameCount++;
                if(nameCount >= 100){
                    nameShown = true;
                    MusicManger.updateMusic();
                }
            }
            if(Gdx.input.justTouched()){
                if(Granny.viewingSeeds){
                    int n = Granny.seedBubble.getClickedIndex(Gdx.input.getX(), Gdx.input.getY());
                    if(n != -1){
                        int flowerType = Granny.getFlowerType(n);
                        if(flowerType != -1){
                            Granny.plantFlower(flowerType);
                            Granny.viewingMenu = false;
                        }
                        Granny.viewingSeeds = false;
                    }
                }
                else if(Granny.viewingMenu){
                    int n = Granny.bubble.getClickedIndex(Gdx.input.getX(), Gdx.input.getY());
                    if(n == -1){
                        Granny.viewingMenu = false;
                    }
                    else {
                        if (Granny.emptySpot) {
                            if (n == 0) {
                                Granny.generateSeedBubble();
                            }
                        } else {
                            if (n == 1) {
                                Granny.waterFlower();
                                Granny.viewingMenu = false;
                            } else if (n == 2) {
                                Granny.pickFlower();
                                Granny.viewingMenu = false;
                            }
                        }
                    }
                }
                else if(!Seedbay.inSeedBay){
                    Granny.setTarget(Gdx.input.getX(), Gdx.input.getY());
                }
            }

            mainGame.begin();

                mainGame.draw(Images.grass, 0, 0);
                if(SeasonRendering.season == 0){
                    mainGame.draw(Images.summerBanner, 0, 450);
                }
                else if(SeasonRendering.season == 1){
                    mainGame.draw(Images.autumnBanner, 0, 450);
//                    mainGame.draw(Images.autumnFloor, 0, 0);
                }
                else if(SeasonRendering.season == 2){
                    mainGame.draw(Images.winterBanner, 0, 450);
                }
                else if(SeasonRendering.season == 3){
                    mainGame.draw(Images.springBanner, 0, 450);
                }
                for(int i = 0; i < 16; i++){
                    mainGame.draw(Images.fence, i * Images.fence.getWidth()*2, 435, 64, 64);
                }
                mainGame.draw(Images.house, -10, 395, 200, 250);
                FlowerManager.drawBedDirt(mainGame);
                for(int n = 0; n < FlowerManager.numBeds; n++) {
                    if(n == Granny.getRow()){
                        Granny.update(mainGame);
                    }
                    FlowerManager.drawBed(mainGame, n);
                }
            mainGame.end();

            seasonalOverlay.begin();
                SeasonRendering.renderSeasons(seasonalOverlay);
            seasonalOverlay.end();

            HUD.begin();
                HUD.draw(Images.seasonDisplay, Gdx.graphics.getWidth() / 2 - Images.seasonDisplay.getWidth() / 2, Gdx.graphics.getHeight() - Images.seasonDisplay.getHeight() / 2 - 20);
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

                HUD.draw(Images.waterBar, 10, 40, Images.waterBar.getWidth()/1.5f, Images.waterBar.getHeight()/1.5f);
                float heightBar = (Images.waterBar.getHeight()/1.5f)/Granny.waterCapacity * Granny.water;
                HUD.draw(Images.waterBarInside, 25, 40, Images.waterBarInside.getWidth()/1.5f-1, heightBar);

                purse = new SpeechBubble("Purse:\n$" + Granny.purse, 500, Color.BLACK, Color.WHITE, 2, true);
                purse.renderText(HUD, 590, 590);
                Granny.drawBubble(HUD, renderer);
            Seedbay.render(HUD, renderer);
            if(!nameShown) {
                HUD.draw(Images.logo, Gdx.graphics.getWidth() / 2 - Images.logo.getWidth() / 2, Gdx.graphics.getHeight() / 2 - Images.logo.getHeight() / 2);
            }
            HUD.end();
        }
    }
}
