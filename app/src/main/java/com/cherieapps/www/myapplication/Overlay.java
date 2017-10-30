package com.cherieapps.www.myapplication;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Typeface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by anelelizabethcervantes on 10/30/17.
 */

public class Overlay {
    Activity activity;
    public Overlay(Activity activity) {
        this.activity= activity;
    }

    public void newOverlay(final FrameLayout parent, int position_x, int position_y, int size_width, int size_height, int drawable, String message, int background, boolean isBackground){

        final ImageView iv = new ImageView(activity);
        TextView tv = new TextView(activity);
        final LinearLayout layout = new LinearLayout(activity);
        int child = 0;

        if (isBackground){
            layout.setBackgroundColor(activity.getResources().getColor(background));
        }
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));


        iv.setImageResource(drawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(size_width, size_height);
        iv.setLayoutParams(layoutParams);
        iv.setX(position_x);
        iv.setY(position_y);
        animateShake(iv);
        layout.addView(iv);

        tv.setText(message);
        tv.setGravity(View.TEXT_ALIGNMENT_CENTER);
        tv.setX(position_x);
        tv.setY(position_y+(size_height/2));
        tv.setTextSize(18);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.addView(tv);

        parent.addView(layout);

        for(int index = 0; index<parent.getChildCount(); ++index) {
            child = index;
            layout.setId(index);
        }

        final int children= child;
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent.removeView(activity.findViewById(children));
            }
        });
    }

    public void animateShake(View view){
        view.setVisibility(View.VISIBLE);
        ObjectAnimator scaleAnim = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.5f);
        scaleAnim.setDuration(1000);
        scaleAnim.setRepeatCount(ValueAnimator.INFINITE);
        scaleAnim.setRepeatMode(ValueAnimator.REVERSE);
        scaleAnim.start();
    }

}

