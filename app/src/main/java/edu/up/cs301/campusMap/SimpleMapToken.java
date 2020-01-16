package edu.up.cs301.campusMap;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

/**
 * <!-- class SimpleMapToken -->
 *
 * This class represents a single map token that can be drawn on a canvas
 *
 * @author Andrew M. Nuxoll
 * @author Steven R. Vegdahl
 * @author <your name here>
 * @version August 2015
 */
public class SimpleMapToken {

    // instance variables
    protected float x; // my x coordinate
    protected float y; // my y coordinate
    protected float radius; //my radius
    protected Paint paint;  //my color
    private int pickColor() {
        Random rand = new Random();
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);
        return Color.rgb(red, green, blue);
    }
    /**
     * Constructor
     */
    public SimpleMapToken(float xCoord, float yCoord) {

        // initialize the instance variables
        x = xCoord;
        y = yCoord;
        radius = 15;
        paint = new Paint();
        paint.setColor(pickColor());
    }//ctor

    /**
     * this token can paint itself on a given canvas
     */
    public void drawOn(Canvas canvas) {
        canvas.drawCircle(x, y, radius, paint);
    }//drawOn

}//class SimpleMapToken
