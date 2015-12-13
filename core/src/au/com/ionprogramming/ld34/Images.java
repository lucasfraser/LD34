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
    public static Texture bedC;
    public static Texture bedL;
    public static Texture bedR;
    public static Texture exc1;
    public static Texture exc2;
    public static Texture seasonDisplay;
    public static Texture selectionSeasons;
    public static Texture dayDisplay;
    public static Texture selectionDays;
    static Texture sbay;
    static Texture seedBayIE;
    public static Texture grass;
    public static Texture summerBanner;
    public static Texture winterBanner;
    public static Texture autumnBanner;
    public static Texture springBanner;
    public static Texture fence;

    public static Texture[] flower1;
    public static Texture[] flower2;
    public static Texture[] flower3;
    public static Texture[] flower4;
    public static Texture[] flower5;
    public static Texture[] flower6;

    public static void loadImages(){
        ion = new Texture("IonProgrammingLogo.png");
        lucas = new Texture("lucas.png");
        leaf = new Texture("leaf.png");
        snow = new Texture("snow.png");
        bedC = new Texture("bedC.png");
        bedL = new Texture("bedL.png");
        bedR = new Texture("bedR.png");
        exc1 = new Texture("exc1.png");
        exc2 = new Texture("exc2.png");
        sbay = new Texture("sbay.png");
        seedBayIE = new Texture("seedBayIE.png");
        grass = new Texture("grass.png");
        summerBanner = new Texture("summer.png");
        winterBanner = new Texture("winter.png");
        autumnBanner = new Texture("autumnBanner.png");
        springBanner = new Texture("springBanner.png");
        fence = new Texture("fence.png");

        flower1 = new Texture[]{new Texture("flowers/flowers_00.png"), new Texture("flowers/flowers_01.png"), new Texture("flowers/flowers_02.png"), new Texture("flowers/flowers_03.png"), new Texture("flowers/flowers_04.png"), new Texture("flowers/flowers_05.png")};
        flower2 = new Texture[]{new Texture("flowers/flowers_06.png"), new Texture("flowers/flowers_07.png"), new Texture("flowers/flowers_08.png"), new Texture("flowers/flowers_09.png"), new Texture("flowers/flowers_10.png"), new Texture("flowers/flowers_11.png")};
        flower3 = new Texture[]{new Texture("flowers/flowers_12.png"), new Texture("flowers/flowers_13.png"), new Texture("flowers/flowers_14.png"), new Texture("flowers/flowers_15.png"), new Texture("flowers/flowers_16.png"), new Texture("flowers/flowers_17.png")};
        flower4 = new Texture[]{new Texture("flowers/flowers_18.png"), new Texture("flowers/flowers_19.png"), new Texture("flowers/flowers_20.png"), new Texture("flowers/flowers_21.png"), new Texture("flowers/flowers_22.png"), new Texture("flowers/flowers_23.png")};
        flower5 = new Texture[]{new Texture("flowers/flowers_24.png"), new Texture("flowers/flowers_25.png"), new Texture("flowers/flowers_26.png"), new Texture("flowers/flowers_27.png"), new Texture("flowers/flowers_28.png"), new Texture("flowers/flowers_29.png")};
        flower6 = new Texture[]{new Texture("flowers/flowers_30.png"), new Texture("flowers/flowers_31.png"), new Texture("flowers/flowers_32.png"), new Texture("flowers/flowers_33.png"), new Texture("flowers/flowers_34.png"), new Texture("flowers/flowers_35.png")};

        seasonDisplay = new Texture("seasons.png");
        selectionSeasons = new Texture("selection.png");

        dayDisplay = new Texture("days.png");
        selectionDays = new Texture("selectionDays.png");
    }
}
