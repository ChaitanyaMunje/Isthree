package com.example.hp.isthree;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.img);
        TranslateAnimation animation=new TranslateAnimation(400.0f,0.0f,0.0f,0.0f);
        animation.setDuration(5000);
        animation.setRepeatCount(6);
        animation.setRepeatMode(2);
       // animation.setFillAfter(true);
        img.startAnimation(animation);
        //Animation animSlide=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide);
       // img.startAnimation(animSlide);
        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
                finish();
            }
        }, 6000);

    }
}
