package com.oliverdixon.app.controllers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.oliverdixon.app.views.MainGameStage;


public class TenPinBowling extends ApplicationAdapter
{
    private static final Vector2 appSize = new Vector2(1000, 480);

    //Stages
    private MainGameStage mainGameStage;

	@Override
	public void create ()
    {
        mainGameStage = new MainGameStage(new ExtendViewport((int)appSize.x, (int)appSize.y), new SpriteBatch());
        Gdx.input.setInputProcessor(mainGameStage);
	}

    public void resize(int width, int height)
    {
        // use true here to center the camera
        // that's what you probably want in case of a UI
        mainGameStage.getViewport().update(width, height, false);
    }

	@Override
	public void render ()
    {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f); //Background color.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainGameStage.act();
        mainGameStage.draw();
	}
}
