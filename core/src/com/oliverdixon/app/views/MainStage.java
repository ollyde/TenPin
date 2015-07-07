package com.oliverdixon.app.views;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.oliverdixon.app.models.Defaults;


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

        //Title
        LabelExtra title = new LabelExtra("ODs Amazing TenPin!", Defaults.getInstance().getDefaultLabelStyle());
        title.setCenter(getWidth() / 2f, getHeight() - (title.getHeight() * 1.20f));
        this.addActor(title);

        //Play Button
        
    }
}
