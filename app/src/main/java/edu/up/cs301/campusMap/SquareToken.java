package edu.up.cs301.campusMap;

import android.graphics.Canvas;

public class SquareToken extends SimpleMapToken {
    public SquareToken(float xCoord, float yCoord) {
        super(xCoord, yCoord);
    }

    public void drawOn(Canvas canvas) {
        canvas.drawRect(x - radius, y - radius, radius, radius, paint);
    }
}
