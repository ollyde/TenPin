package com.oliverdixon.app.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

import java.text.DecimalFormat;

/**
 * Created by Oliver Dixon on 07/07/15 under Polygon Attraction
 * This class is private and owned by Oliver Dixon / Polygon Attraction.
 * Use of this class must first be consulted by Oliver Dixon (info@polygonattraction.com)
 * GL and thanks for reading/playing/using the app.
 */
public class GameController //Singleton
{
    public static final int MAX_NUMBER_OF_FRAMES = 10;
    public static final int NUMBER_OF_PINS_PER_FRAME = 10;

    //Optional..
    public static final int BONUS_FRAMES_CAP = 2;
    private Array<Frame> frames;

    //Singleton management.
    private static GameController ourInstance = new GameController();
    public static GameController getInstance() {
        if (ourInstance == null) {
            ourInstance = new GameController();
        }
        return ourInstance;
    }
    private GameController() {}

    public void reset(){
        frames = new Array<Frame>();
    }

    public void simulateBowls(int numberOfBowls)
    {
        for(int eachFrame = 0; eachFrame < numberOfBowls; eachFrame++)
        {
            if(frames.size < MAX_NUMBER_OF_FRAMES)
            {
                frames.add(new Frame(frames));
            }
            else
            {
                rollBonusFrames();
            }
        }
    }

    private void rollBonusFrames()
    {
        if(frames.size - MAX_NUMBER_OF_FRAMES < BONUS_FRAMES_CAP && frames.peek().getBonusBowls() > 0)
        {
            frames.add(new Frame(frames));
            rollBonusFrames();
        }
    }

    public String getResult()
    {
        String result = "";

        int frameNumber = 0;
        int totalScore = 0;
        for(Frame eachFrame : frames)
        {
            frameNumber++;
            result += "\nFrame " + String.valueOf(frameNumber) + ": " + eachFrame.getBowl1().getPinsHit();

            if(eachFrame.getBowl1().getBowlEvent() == Bowl.BowlEvent.STRIKE){
                result += "(" + Bowl.BowlEvent.STRIKE.name() + ")";
            }
            else if(eachFrame.getBowl1().getBowlEvent() != Bowl.BowlEvent.SCORE)
            {
                Gdx.app.error("GameController:getResult","First bowl is equal to Spare which should be impossible.");
            }

            if(eachFrame.getBowl2() != null)
            {
                result += " + " + eachFrame.getBowl2().getPinsHit();
                if(eachFrame.getBowl2().getBowlEvent() == Bowl.BowlEvent.SPARE){
                    result += "(" + Bowl.BowlEvent.SPARE.name() + ")";
                }
                else if(eachFrame.getBowl2().getBowlEvent() != Bowl.BowlEvent.SCORE)
                {
                    Gdx.app.error("GameController:getResult","Second bowl is equal to Strike which should be impossible.");
                }
            }

            result += " Frame Score: " + eachFrame.getScore();
            totalScore += eachFrame.getScore();
            result += "\n ---";
        }

        result += "\n\nTotal Score: " + String.valueOf(totalScore);

        return result;
    }

    private static class Frame
    {
        private Bowl bowl1, bowl2;
        private int scoreForThisFrame;
        private int bonusBowls = 0;

        public Frame(Array<Frame> previousFrames)
        {
            //Do the bowling here.
            bowl1 = bowl(null);
            addBonusToOtherFrames(previousFrames, bowl1);
            if(bowl1.getBowlEvent() == Bowl.BowlEvent.SCORE)
            {
                bowl2 = bowl(bowl1);
                addBonusToOtherFrames(previousFrames, bowl2);
                //Making sure it's set to a spare.
                if(bowl2.getBowlEvent() == Bowl.BowlEvent.SPARE)
                {
                    setBonusBowls(Bowl.BowlEvent.SPARE);
                }
            }
            else
            {
                setBonusBowls(bowl1.getBowlEvent());
            }

            //Basic score
            scoreForThisFrame = 0;
            scoreForThisFrame += bowl1.getPinsHit();
            if(bowl2 != null){
                scoreForThisFrame += bowl2.getPinsHit();
            }

        }

        private void addBonusToOtherFrames(Array<Frame> previousFrames, Bowl bowl)
        {
            if(previousFrames.size > 1)
            {
                previousFrames.peek().addToLastScoreAndDecreaseBonus(bowl.getPinsHit());

                if(previousFrames.size > 2)
                {
                    previousFrames.get(previousFrames.size - 2).addToLastScoreAndDecreaseBonus(bowl.getPinsHit());
                }
            }
        }

        public void addToLastScoreAndDecreaseBonus(int amount)
        {
            if(bonusBowls != 0)
            {
                scoreForThisFrame += amount;
                bonusBowls--;
            }
        }

        private void setBonusBowls(Bowl.BowlEvent bowlEvent)
        {
            if(bowlEvent == Bowl.BowlEvent.SPARE)
            {
                bonusBowls = 1;
            }
            else{
                bonusBowls = 2;
            }
        }

        private int getScore()
        {
            return scoreForThisFrame;
        }

        public Bowl getBowl1() {
            return bowl1;
        }

        public Bowl getBowl2() {
            return bowl2;
        }

        private Bowl bowl(Bowl lastBowl)
        {
            int numberOfPinsHit;

            if(lastBowl != null)
            {
                //Hit the remaining pins.
                numberOfPinsHit = MathUtils.random(0, NUMBER_OF_PINS_PER_FRAME - lastBowl.getPinsHit());
            }
            else
            {
                //Potential to hit max number of pins.
                numberOfPinsHit = MathUtils.random(0, NUMBER_OF_PINS_PER_FRAME);
            }

            if(lastBowl == null && numberOfPinsHit == NUMBER_OF_PINS_PER_FRAME) //Strike
            {
                return new Bowl(numberOfPinsHit, Bowl.BowlEvent.STRIKE);
            }
            else if(lastBowl != null && numberOfPinsHit + lastBowl.getPinsHit() == NUMBER_OF_PINS_PER_FRAME) //Spare
            {
                return new Bowl(numberOfPinsHit, Bowl.BowlEvent.SPARE);
            }
            else
            {
                return new Bowl(numberOfPinsHit, Bowl.BowlEvent.SCORE);
            }
        }

        public int getBonusBowls() {
            return bonusBowls;
        }
    }

    private static class Bowl
    {
        private int pinsHit;
        private BowlEvent bowlEvent;
        private enum BowlEvent{
            SCORE, STRIKE, SPARE
        }

        public Bowl(int pinsHit, BowlEvent bowlEvent)
        {
            this.pinsHit = pinsHit;
            this.bowlEvent = bowlEvent;
        }

        public int getPinsHit() {
            return pinsHit;
        }

        public BowlEvent getBowlEvent() {
            return bowlEvent;
        }
    }
}
