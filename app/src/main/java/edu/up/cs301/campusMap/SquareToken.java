package edu.up.cs301.campusMap;

import android.graphics.Canvas;

/**
 * <!-- class SquareToken -->
 *
 * This class extends SimpleMapToken to create a token that is a square.
 *
 * @author Justin Lee
 * @version January 2020
 */

public class SquareToken extends SimpleMapToken {
    public SquareToken(float xCoord, float yCoord) {
        super(xCoord, yCoord);
    }

    public void drawOn(Canvas canvas) {
        canvas.drawRect(x - radius, y - radius, x + radius, y + radius, paint);
    }
}
