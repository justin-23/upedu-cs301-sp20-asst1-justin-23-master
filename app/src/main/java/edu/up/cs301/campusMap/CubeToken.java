package edu.up.cs301.campusMap;

import android.graphics.Canvas;

public class CubeToken extends SimpleMapToken {
    public CubeToken(float xCoord, float yCoord) {
        super(xCoord, yCoord);
    }

    public void drawOn(Canvas canvas) {
        //canvas.drawRect(x - radius, y - radius, x + radius, y + radius, paint);
        canvas.drawLine(x - radius, y - radius, x + radius, y + radius, paint);
    }
}

//https://developer.android.com/reference/android/graphics/Color