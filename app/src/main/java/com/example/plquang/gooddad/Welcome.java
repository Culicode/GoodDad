package com.example.plquang.gooddad;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Welcome extends AppCompatActivity {
ImageView imglogo,imgStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        AnhXa();
        Animation animation_fade= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imglogo.startAnimation(animation_fade);
       Animation animation_rolate=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rolate);
       imgStart.startAnimation(animation_rolate);
       imgStart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               final Animation myAnim = AnimationUtils.loadAnimation(Welcome.this, R.anim.bounce);
               imgStart.startAnimation(myAnim);
               Intent intent=new Intent(Welcome.this,MainActivity.class);
               startActivity(intent);
               overridePendingTransition(R.anim.out,R.anim.in);

               finish();
           }
       });
    }
    class MyBounceInterpolator implements android.view.animation.Interpolator {
        private double mAmplitude = 1;
        private double mFrequency = 10;

        MyBounceInterpolator(double amplitude, double frequency) {
            mAmplitude = amplitude;
            mFrequency = frequency;
        }

        public float getInterpolation(float time) {
            return (float) (-1 * Math.pow(Math.E, -time/ mAmplitude) *
                    Math.cos(mFrequency * time) + 1);
        }
    }
    public void AnhXa()
    {
        imglogo=(ImageView) findViewById(R.id.imageLogo);
        imgStart=(ImageView) findViewById(R.id.imageStart);
    }
}
