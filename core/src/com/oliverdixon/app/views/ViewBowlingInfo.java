package com.oliverdixon.app.views;


import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.oliverdixon.app.models.Defaults;

/**
 * Created by Oliver Dixon on 07/07/15 under Polygon Attraction
 * This class is private and owned by Oliver Dixon / Polygon Attraction.
 * Use of this class must first be consulted by Oliver Dixon (info@polygonattraction.com)
 * GL and thanks for reading/playing/using the app.
 */
public class ViewBowlingInfo extends TextArea
{
    public ViewBowlingInfo() {
        super("Welcome to Oliver Dixon's TenPin Bowling emulator.", Defaults.getInstance().getDefaultSkin());

    }

    public void newGame(){

    }
}
