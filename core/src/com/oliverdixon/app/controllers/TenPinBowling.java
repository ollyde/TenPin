package com.oliverdixon.app.controllers;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.oliverdixon.app.views.MainStage;


public class TenPinBowling extends ApplicationAdapter
{
    private static final Vector2 appSize = new Vector2(800, 480);

	SpriteBatch batch;

    //Stages
    MainStage mainStage;
	
	@Override
	public void create ()
    {
        batch = new SpriteBatch();
        mainStage = new MainStage(new ExtendViewport((int)appSize.x, (int)appSize.y), batch);
	}

    public void resize(int width, int height)
    {
        // use true here to center the camera
        // that's what you probably want in case of a UI
        mainStage.getViewport().update(width, height, false);
    }

	@Override
	public void render ()
    {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.draw();

        /*
		batch.begin();
        mainStage.draw();
		batch.end();
		*/
	}
}
