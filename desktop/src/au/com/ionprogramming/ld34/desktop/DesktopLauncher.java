package au.com.ionprogramming.ld34.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import au.com.ionprogramming.ld34.LD34;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Floral Empire - LD34 - Ion Programming";
		config.width = 1000;
		config.height = 600;
		new LwjglApplication(new LD34(), config);
	}
}
