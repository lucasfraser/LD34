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
    static Texture sbay;
    static Texture seedBayIE;
    public static Texture grass;
    public static Texture summberBanner;
    public static Texture winterBanner;
    public static Texture fence;


    public static void loadImages(){
        ion = new Texture("IonProgrammingLogo.png");
        lucas = new Texture("lucas.png");
        leaf = new Texture("leaf.png");
        snow = new Texture("snow.png");
        sbay = new Texture("sbay.png");
        seedBayIE = new Texture("seedBayIE.png");
        grass = new Texture("grass.png");
        summberBanner = new Texture("summer.png");
        winterBanner = new Texture("winter.png");
        fence = new Texture("fence.png");

    }
}
