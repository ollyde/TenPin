package com.oliverdixon.app.views;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.oliverdixon.app.controllers.GameController;
import com.oliverdixon.app.models.Defaults;


/**
 * Created by Oliver Dixon on 07/07/15 under Polygon Attraction
 * This class is private and owned by Oliver Dixon / Polygon Attraction.
 * Use of this class must first be consulted by Oliver Dixon (info@polygonattraction.com)
 * GL and thanks for reading/playing/using the app.
 */
public class MainGameStage extends Stage
{
    private ViewLabelExtra textAreaBowlingInfo;
    private ScrollPane scrollPane;

    public MainGameStage(Viewport viewport, Batch batch)
    {
        super(viewport, batch);

        final float padding = getWidth() * 0.03f; //TODO Would usually be stored in a model under padding's.

        //TODO The text in the following would usually be in a language controller so we can easily load other languages.

        //Title
        ViewLabelExtra title = new ViewLabelExtra("Olly's TenPin!", Defaults.getInstance().getDefaultSkin(), "default");
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

        final float widthOfScrollableArea = playButton.getX() - (padding * 2f);

        //Main Bowling Info
        textAreaBowlingInfo = new ViewLabelExtra("Welcome to Oliver Dixon's Amazing TenPin Bowling!", Defaults.getInstance().getDefaultSkin(), "small");
        textAreaBowlingInfo.setAlignment(Align.left);
        textAreaBowlingInfo.setWrap(true);

        scrollPane = new ScrollPane(textAreaBowlingInfo);
        scrollPane.setBounds(padding, padding, widthOfScrollableArea, title.getY() - (padding * 2f));
        scrollPane.setScrollingDisabled(true, false);
        this.addActor(scrollPane);

        GameController.getInstance().reset();

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
        GameController.getInstance().reset();
        textAreaBowlingInfo.setText("Game Reset");
    }

    private void bowlRandom()
    {
        GameController.getInstance().simulateBowls(MathUtils.round((float)GameController.MAX_NUMBER_OF_FRAMES * MathUtils.random()));
        textAreaBowlingInfo.setText(GameController.getInstance().getResult());
    }


}
