package com.cherieapps.www.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.cherieapps.www.myapplication.utilities.Overlay;


public class MainActivity extends AppCompatActivity {

    ImageView img_background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img_background = (ImageView) findViewById(R.id.img_background);

        addOverlay();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help:
                addOverlay();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addOverlay() {
        Intent overlay = new Intent(MainActivity.this, OverlayActivity.class);
        startActivity(overlay);
    }


}