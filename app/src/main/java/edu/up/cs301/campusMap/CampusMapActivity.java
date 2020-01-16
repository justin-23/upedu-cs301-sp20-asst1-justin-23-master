package edu.up.cs301.campusMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RadioButton;
/**
 * <!-- class CampusMapActivity -->
 *
 * The activity class for our Campus Map app.
 *
 * =====================================================
 * CS 301 STUDENTS SHOULD NOT NEED TO MODIFY THIS FILE
 * =====================================================
 *
 * @author Steven R. Vegdahl
 * @version August 2015
 */
public class CampusMapActivity extends Activity implements View.OnTouchListener {



    // instance variables to hold GUI components
    private CampusMapImageView imageView; // the view that shows the map
    private RadioButton[] radioButtons; // array containing our radio buttons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // initialize with our layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campus_map);

        // initialize the view with the map; set its listener
        imageView = (CampusMapImageView)findViewById(R.id.imageView);
        imageView.setOnTouchListener(this);

        // initialize the array of radio buttons
        radioButtons = new RadioButton[]{
                (RadioButton)findViewById(R.id.radioButton),
                (RadioButton)findViewById(R.id.radioButton2),
                (RadioButton)findViewById(R.id.radioButton3),
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_campus_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View v, MotionEvent me) {
        // do nothing on the event was a "down" touch
        if (me.getAction() != MotionEvent.ACTION_DOWN) return false;

        // get the x and y coordinates for the event
        float x = me.getX();
        float y = me.getY();

        // create the appropriate token and give it to the image
        SimpleMapToken token = TokenFactory.createMapToken(x, y, getCheckedIndex());
        imageView.setToken(token);

        // for a "repaint" so that that the new token shows up
        imageView.invalidate();

        // returnn true because we've handled the event
        return true;
    }

    /**
     * method that tells us the index of the radio-button that is checked.
     * @return 0, 1 or 2, depending on which radio button is checked; returns
     *   -1 if none is checked.
     */
    public int getCheckedIndex() {
        // run through the array of radio buttons, returning when we find
        // a checked one
        for (int i = 0; i < radioButtons.length; i++) {
            if (radioButtons[i].isChecked()) {
                return i;
            }
        }

        // return -1 if none were checked
        return -1;
    }
}
