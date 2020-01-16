package edu.up.cs301.campusMap;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * <!-- class CampusMapImageView -->
 *
 * This class displays the campus map.
 *
 * @author Steven R. Vegdahl
 * @author <your name here>
 * @version August 2015
 */
public class CampusMapImageView extends ImageView {

    // instance variables for the current and previous tokens
    private SimpleMapToken token;
    private SimpleMapToken prevToken;

    public void setToken(SimpleMapToken tok) {
        // set the current and previous tokens, based on the new
        // token that has been given to us
        prevToken = token;
        token = tok;
    }

    /**
     * two-argument version of the constructor
     *
     * @param context Context object
     * @param attrs AttributeSet object
     */
    public CampusMapImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // perform the common constructor operations
        init();
    }

    /**
     * one-argument version of the constructor
     *
     * @param context Context object
     */
    public CampusMapImageView(Context context) {
        super(context);
        // perform the common constructor operations
        init();
    }

    /**
     * performs initialization common to both constructors
     */
    private void init() {
        token = null;
        prevToken = null;
    }

    @Override
    protected void onDraw(Canvas g) {
        super.onDraw(g);
        // if the previous token exists, draw it
        if (prevToken != null) {
            prevToken.drawOn(g);
        }
        // if the current token exists, draw it
        if (token != null) {
            token.drawOn(g);
        }
    }
}


