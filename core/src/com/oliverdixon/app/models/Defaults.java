package com.oliverdixon.app.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by Oliver Dixon on 07/07/15 under Polygon Attraction
 * This class is private and owned by Oliver Dixon / Polygon Attraction.
 * Use of this class must first be consulted by Oliver Dixon (info@polygonattraction.com)
 * GL and thanks for reading/playing/using the app.
 *
 * Contains default objects for things like styles, fonts, colors.
 */
public class Defaults //Singleton
{
    private BitmapFont defaultFont;
    private Label.LabelStyle defaultLabelStyle;

    //Singleton management.
    private static Defaults ourInstance = new Defaults();
    public static Defaults getInstance()
    {
        if (ourInstance == null) {
            ourInstance = new Defaults();
        }
        return ourInstance;
    }



    private Defaults() {
        //TODO Not thread safe but doesn't matter for this exercise. Usually I'd use a special asset loader class I've made to load textures & sounds in on a 'loading/splash' screen.

        defaultFont = new BitmapFont(Gdx.files.internal("customfont.fnt"));
        defaultLabelStyle = new Label.LabelStyle(defaultFont, Color.WHITE);


    }

    public Label.LabelStyle getDefaultLabelStyle() {
        return defaultLabelStyle;
    }
}
