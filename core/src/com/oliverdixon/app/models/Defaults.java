package com.oliverdixon.app.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

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
    public static final String
            ATLAS_PACK = "tenpin_atlas.atlas",
            SKIN = "skin.json"
            ;

    private AssetManager assetManager;

    private Skin defaultSkin;

    //Singleton management.
    private static Defaults ourInstance = new Defaults();
    public static Defaults getInstance()
    {
        if (ourInstance == null) {
            ourInstance = new Defaults();
        }
        return ourInstance;
    }



    private Defaults()
    {
        //TODO Not thread safe but doesn't matter for this exercise. Usually I'd use a special asset loader class I've made to load textures & sounds in on a 'loading/splash' screen.

        assetManager = new AssetManager();
        assetManager.load(ATLAS_PACK,TextureAtlas.class);

        //TODO Extremely not thread safe. Usually where the load/splash screen would happen. Won't matter for small assets.
        while(!assetManager.update()){}

        TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal(ATLAS_PACK));
        defaultSkin = new Skin(Gdx.files.internal(SKIN), textureAtlas);
    }

    public Skin getDefaultSkin() {
        return defaultSkin;
    }
}
