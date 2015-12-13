package au.com.ionprogramming.ld34;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Lucas on 13/12/2015.
 */
public class Images {

    static Texture ion;
    static Texture lucas;
    static Texture leaf;
    static Texture snow;

    public static void loadImages(){
        ion = new Texture("IonProgrammingLogo.png");
        lucas = new Texture("lucas.png");
        leaf = new Texture("leaf.png");
        snow = new Texture("snow.png");
    }
}
