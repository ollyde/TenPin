package com.oliverdixon.app;

/**
 * Created by Oliver Dixon on 07/07/15 under Polygon Attraction
 * This class is private and owned by Oliver Dixon / Polygon Attraction.
 * Use of this class must first be consulted by Oliver Dixon (info@polygonattraction.com)
 * GL and thanks for reading/playing/using the app.
 */
public class CustomTools //Singleton
{
    //Singleton management.
    private static CustomTools ourInstance = new CustomTools();

    public static CustomTools getInstance() {
        if (ourInstance == null) {
            ourInstance = new CustomTools();
        }
        return ourInstance;
    }

    private CustomTools() {
    }
}
