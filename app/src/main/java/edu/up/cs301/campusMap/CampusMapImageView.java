package edu.up.cs301.campusMap;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * <!-- class CampusMapImageView -->
 *
 * This class displays the campus map.
 *
 * @author Steven R. Vegdahl
 * @author Justin Lee
 * @version January 2020
 */
public class CampusMapImageView extends ImageView {

    // instance variables for the current and previous tokens
    private SimpleMapToken token;
    private ArrayList<SimpleMapToken> previousTokens = new ArrayList<SimpleMapToken>();

    public void setToken(SimpleMapToken tok) {
        // set the current and previous tokens, based on the new
        // token that has been given to us
        previousTokens.add(token);

        token = tok;
        /*(
        if (previousTokens.size() > 5) {
            token = null; // Not sure how to do a command line output, so debugging by intentionally crashing
        }
        *.
         */
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
    }

    @Override
    protected void onDraw(Canvas g) {
        super.onDraw(g);
        // if the previous token exists, draw it
        for (SimpleMapToken token_ : previousTokens) {
            if (token_ != null) {
                token_.drawOn(g);
            }
        }
        // if the current token exists, draw it
        if (token != null) {
            token.drawOn(g);
        }
    }
}


