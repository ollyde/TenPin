package com.oliverdixon.app.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.oliverdixon.app.models.Defaults;


/**
 * Created by Oliver Dixon on 07/07/15 under Polygon Attraction
 * This class is private and owned by Oliver Dixon / Polygon Attraction.
 * Use of this class must first be consulted by Oliver Dixon (info@polygonattraction.com)
 * GL and thanks for reading/playing/using the app.
 */
public class MainGameStage extends Stage
{
    private TextArea textAreaBowlingInfo;

    public MainGameStage(Viewport viewport, Batch batch)
    {
        super(viewport, batch);

        final float padding = Gdx.graphics.getPpcX() * 0.50f; //TODO Would usually be stored in a model under padding's. This is 1cm & 0.50.

        //TODO The text in the following would usually be in a language controller so we can easily load other languages.

        //Title
        ViewLabelExtra title = new ViewLabelExtra("Amazing TenPin!", Defaults.getInstance().getDefaultSkin(), "default");
        title.setPosition((getWidth() / 2f) - (title.getWidth() / 2f), getHeight() - (title.getHeight() + padding));
        this.addActor(title);

        //Bowl Button
        final TextButton playButton = new TextButton("Bowl", Defaults.getInstance().getDefaultSkin());
        playButton.setPosition(getWidth() - (playButton.getWidth() + padding), padding);
        this.addActor(playButton);

        //Reset Button
        final TextButton resetButton = new TextButton("New", Defaults.getInstance().getDefaultSkin());
        resetButton.setPosition(getWidth() - (playButton.getWidth() + padding), playButton.getY() + playButton.getHeight() + (padding));
        this.addActor(resetButton);

        //Main Bowling Info
        textAreaBowlingInfo = new TextArea("Welcome to Oliver Dixon's amazing TenPin!", Defaults.getInstance().getDefaultSkin());
        textAreaBowlingInfo.setAlignment(Align.center);
        textAreaBowlingInfo.setText(
                "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes" +
                        "test test test tes test tes test tes test tes test tes test tes test tes test tes test tes test tes 1"
        );

        ScrollPane scrollPane = new ScrollPane(textAreaBowlingInfo);
        scrollPane.setBounds(padding, padding, playButton.getX() - padding, title.getY() - (padding * 2f));
        scrollPane.setScrollingDisabled(false, true);
        textAreaBowlingInfo.setWidth(scrollPane.getPrefWidth());
        this.addActor(scrollPane);

        //Listener for bowl button.
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                playButton.setChecked(false); //Reset button style state.
                bowlRandom();
                super.clicked(event, x, y);
            }
        });

        //Listener for reset button.
        resetButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                resetButton.setChecked(false); //Reset button style state.
                newGame();
                super.clicked(event, x, y);
            }
        });
    }

    private void newGame()
    {
        
    }

    private void bowlRandom()
    {

    }


}
