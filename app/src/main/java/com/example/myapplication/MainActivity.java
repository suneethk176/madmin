package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static  int SPLASH_SCREEN = 1000;
    Animation topAnim,bottomAnim;
    ImageView image;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


//        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
//        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image = findViewById(R.id.imageView2);
        logo = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView2);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this,login.class);
                        startActivity(intent);
                        finish();
                    }
                },SPLASH_SCREEN);


//        new Handler().postDelayed(() -> {
//            Intent intent = new Intent(MainActivity.this,login.class);
//            android.util.Pair[] pairs = new android.util.Pair[2];
//            pairs[0] = new android.util.Pair(image,"logoimage");
//            pairs[0] = new android.util.Pair(logo,"logotext");
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
//                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
//                startActivity(intent, options.toBundle());
//            }
//        }, SPLASH_SCREEN);
//
   }
}