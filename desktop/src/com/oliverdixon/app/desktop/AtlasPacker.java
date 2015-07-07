package com.oliverdixon.app.desktop;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;

/**
 * Created by Oliver Dixon on 07/07/15 under Polygon Attraction
 * This class is private and owned by Oliver Dixon / Polygon Attraction.
 * Use of this class must first be consulted by Oliver Dixon (info@polygonattraction.com)
 * GL and thanks for reading/playing/using the app.
 */
public class AtlasPacker
{
    public static void main (String[] args)
    {
        TexturePacker.Settings tpSettings = new TexturePacker.Settings();
        tpSettings.maxWidth = 2048;
        tpSettings.maxHeight = 2048;
        tpSettings.filterMag = Texture.TextureFilter.MipMapLinearNearest;
        tpSettings.filterMin = Texture.TextureFilter.Nearest;
        tpSettings.pot = true;
        tpSettings.useIndexes = false;
        tpSettings.outputFormat = "png";
        tpSettings.combineSubdirectories = true;
        tpSettings.premultiplyAlpha = true;
        TexturePacker.process(tpSettings, args[0], args[1], args[2]);
    }
}
