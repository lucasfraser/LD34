package au.com.ionprogramming.ld34;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Created by Lucas on 14/12/2015.
 */
public class MusicManger {
    public static Music autumn;
    public static Music winter;
    public static Music spring;
    public static Music summer;

    public static void loadMusic(){
        autumn = Gdx.audio.newMusic(Gdx.files.internal("peaceful1(autumn).mp3"));
        winter = Gdx.audio.newMusic(Gdx.files.internal("peaceful2(winter).mp3"));
        spring = Gdx.audio.newMusic(Gdx.files.internal("peaceful3(spring).mp3"));
        summer = Gdx.audio.newMusic(Gdx.files.internal("peaceful1(autumn).mp3"));
        autumn.setLooping(true);
        winter.setLooping(true);
        spring.setLooping(true);
        summer.setLooping(true);
    }

    public static void updateMusic(){
        if(SeasonRendering.season == 0){
            summer.play();
            spring.stop();
        }
        else if(SeasonRendering.season == 1){
            autumn.play();
            summer.stop();
        }
        else if(SeasonRendering.season == 2){
            winter.play();
            autumn.stop();
        }
        else if(SeasonRendering.season == 3){
            spring.play();
            winter.stop();
        }
    }


}
