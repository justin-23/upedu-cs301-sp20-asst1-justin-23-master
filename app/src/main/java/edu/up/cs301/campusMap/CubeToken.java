package edu.up.cs301.campusMap;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/**
 * <!-- class CubeToken -->
 *
 * This class extends SimpleMapToken to create a cube token.
 *
 * @author Justin Lee
 * @version January 2020
 */

public class CubeToken extends SimpleMapToken {
    public CubeToken(float xCoord, float yCoord) {
        super(xCoord, yCoord);
    }

    public void drawOn(Canvas canvas) {
        int origional = paint.getColor();

        canvas.drawRect(x - radius * 3 / 2, y - radius * 3 / 2, x + radius / 2, y + radius / 2, paint);
        // Far face of the cube
        paint.setStrokeWidth(radius * 2 *(float) Math.sqrt(2));
        canvas.drawLine(x - radius / 2, y - radius / 2, x + radius / 2, y + radius / 2, paint);
        // Draws the main body of the shape, that will be covered
        paint.setARGB(100, 0, 0, 0); //Transparent black.
        Path shade = new Path();
        shade.moveTo(x - radius * 3 / 2, y - radius * 3 / 2); // Top Left
        shade.lineTo(x - radius * 3 / 2, y + radius / 2);   // Bottom Left
        shade.lineTo(x - radius / 2, y + radius * 3 / 2); // Bottom Right
        shade.lineTo(x - radius / 2, y - radius / 2);   // Top Right
        shade.close();
        canvas.drawPath(shade, paint);

        // Draws the shaded paralellogram on the left side.

        paint.setARGB(100, 255, 255, 255); // A transparent-ish white.
        Path light = new Path();
        light.moveTo(x - radius * 3 / 2, y - radius * 3 / 2); // Top Left
        light.lineTo(x + radius / 2, y - radius * 3 / 2);   // Top Right
        light.lineTo(x + radius * 3 / 2, y - radius / 2);   // Bottom Right
        light.lineTo(x - radius / 2 , y - radius / 2);  // Bottom Left
        light.close();
        canvas.drawPath(light, paint);
        //Draws the tinted paralellogram on the top.

        paint.setColor(origional);
        canvas.drawRect(x + radius * 3 / 2, y + radius * 3 / 2, x - radius / 2, y - radius / 2, paint);
        // Draws the front face of the cube.
   }
}
