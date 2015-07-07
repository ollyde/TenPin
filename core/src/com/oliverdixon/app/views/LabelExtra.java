package com.oliverdixon.app.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by Oliver Dixon on 07/07/15 under Polygon Attraction
 * This class is private and owned by Oliver Dixon / Polygon Attraction.
 * Use of this class must first be consulted by Oliver Dixon (info@polygonattraction.com)
 * GL and thanks for reading/playing/using the app.
 */

//TODO Example of me extending existing framework classes for my own advantage.
public class LabelExtra extends Label
{

    public LabelExtra(CharSequence text, Skin skin) {
        super(text, skin);
    }

    public LabelExtra(CharSequence text, Skin skin, String styleName) {
        super(text, skin, styleName);
    }

    public LabelExtra(CharSequence text, Skin skin, String fontName, Color color) {
        super(text, skin, fontName, color);
    }

    public LabelExtra(CharSequence text, Skin skin, String fontName, String colorName) {
        super(text, skin, fontName, colorName);
    }

    public LabelExtra(CharSequence text, LabelStyle style) {
        super(text, style);
    }

    //TODO My own extended methods as they didn't exist in the Scene2D framework.

    public void setCenter(float centerX, float centerY)
    {
        this.setBounds(
                centerX - (this.getWidth() / 2f),
                centerY - (this.getHeight() / 2f),
                getWidth(),
                getHeight()
        );
    }
}
