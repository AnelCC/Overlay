package com.cherieapps.www.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    ImageView img_background;
    FrameLayout frameLayout;
    Overlay overlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overlay = new Overlay(this);

        img_background = (ImageView) findViewById(R.id.img_background);
        frameLayout = (FrameLayout) findViewById(R.id.fl_background);

        overlay.newOverlay(frameLayout, 150, 100, 100, 50, R.drawable.arrow1, "Para uno nuevo de click aqui", R.color.colorOpacityBlack, true);
        overlay.newOverlay(frameLayout, 350, 300, 100, 50, R.drawable.arrow1, "Segundo click aqui", 0, false);
        overlay.newOverlay(frameLayout, 150, 500, 100, 50, R.drawable.arrow1, "Tercero uno nuevo de click aqui", 0, false);
        overlay.newOverlay(frameLayout, 650, 300, 100, 50, R.drawable.arrow1, "Cuarto uno nuevo de click aqui", 0, false);
        overlay.newOverlay(frameLayout, 500, 400, 100, 50, R.drawable.arrow1, "Quinto uno nuevo de click aqui", 0, false);
    }

    

}