package com.oliverdixon.app.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.math.Vector2;
import com.oliverdixon.app.TenPinBowling;

public class DesktopLauncher
{
    private static Vector2 nexus5ResDesktop = new Vector2(800, 480);

	public static void main (String[] arg)
    {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = (int)nexus5ResDesktop.x;
        config.height = (int)nexus5ResDesktop.y;
        config.useHDPI = true;

		new LwjglApplication(new TenPinBowling(), config);
	}
}
