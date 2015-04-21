package com.example.administrator.s01e17_progressbar;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;


public class MainActivity extends ActionBarActivity {

    private ProgressBar progressBar;
    private Button firstButton;
    private Button secondButton;

    private SeekBar seekbar;
    private RatingBar ratingBar;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.firstProgressBar);
        progressBar.setMax(100);
        progressBar.setProgress(20);
        progressBar.setSecondaryProgress(40);

        firstButton = (Button)findViewById(R.id.firstButton);
        secondButton = (Button)findViewById(R.id.secondButton);

        ButtonListener1 buttonListener1 = new ButtonListener1();
        firstButton.setOnClickListener(buttonListener1);
        ButtonListener2 buttonListener2 = new ButtonListener2();
        secondButton.setOnClickListener(buttonListener2);

        boolean flag = progressBar.isIndeterminate();

        seekbar = (SeekBar)findViewById(R.id.firstSeekBar);
        SeekBarListener seekBarListener = new SeekBarListener();
        seekbar.setOnSeekBarChangeListener(seekBarListener);

        ratingBar = (RatingBar)findViewById(R.id.firstRatingBar);
        RatingBarListener ratingBarListener = new RatingBarListener();
        ratingBar.setOnRatingBarChangeListener(ratingBarListener);

        button = (Button)findViewById(R.id.button);
        ButtonListener buttonListener = new ButtonListener();
        button.setOnClickListener(buttonListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    class ButtonListener1 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            progressBar.incrementProgressBy(10);
            progressBar.incrementSecondaryProgressBy(10);
        }
    }

    class ButtonListener2 implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            progressBar.setProgress(0);
            progressBar.setSecondaryProgress(0);
        }
    }

    class SeekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            System.out.println("progress: " + progress + " fromUser: " + fromUser);
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            System.out.println("on start Tracking Touch");
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            System.out.println("on Stop Tracking Touch");
        }
    }

    class RatingBarListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            System.out.println("rating: " + rating + "fromUser: " + fromUser);
        }
    }

    class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ratingBar.setRating((float) (ratingBar.getRating() + 1.0));
        }
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
}
