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
               Intent intent=new Intent(Welcome.this,MainActivity.class);
               startActivity(intent);
               overridePendingTransition(R.anim.out,R.anim.in);
               finish();
           }
       });
    }
    public void AnhXa()
    {
        imglogo=(ImageView) findViewById(R.id.imageLogo);
        imgStart=(ImageView) findViewById(R.id.imageStart);
    }
}
