package com.oliverdixon.app.views;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.oliverdixon.app.models.Defaults;
import com.oliverdixon.app.tools.CustomTools;


/**
 * Created by Oliver Dixon on 07/07/15 under Polygon Attraction
 * This class is private and owned by Oliver Dixon / Polygon Attraction.
 * Use of this class must first be consulted by Oliver Dixon (info@polygonattraction.com)
 * GL and thanks for reading/playing/using the app.
 */
public class MainStage extends Stage
{
    public MainStage(Viewport viewport, Batch batch)
    {
        super(viewport, batch);

        final float paddingMultiplier = 1.20f; //TODO Would usually be stored in a model under padding's.

        //Title
        ViewLabelExtra title = new ViewLabelExtra("Amazing TenPin!", Defaults.getInstance().getDefaultSkin(), "default");
        title.setPosition((getWidth() / 2f) - (title.getWidth() / 2f), getHeight() - (title.getHeight() * paddingMultiplier));
        this.addActor(title);

        //Play Button
        final TextButton playButton = new TextButton("Play", Defaults.getInstance().getDefaultSkin());
        playButton.setPosition(getWidth() - (playButton.getWidth() * paddingMultiplier), playButton.getHeight() + (playButton.getWidth() * (1f - paddingMultiplier)));
        this.addActor(playButton);

        //Main Bowling Info
        final ViewBowlingInfo bowlingInfo = new ViewBowlingInfo();
        this.addActor(bowlingInfo);

        //Listener for button.
        playButton.addListener(new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y)
            {
                playButton.setChecked(false); //Reset button style state.
                bowlingInfo.newGame();
                super.clicked(event, x, y);
            }
        });
    }
}
