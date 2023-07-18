package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        lottieAnimationView=findViewById(R.id.lottie_layer_name);
        lottieAnimationView.animate();

//        lottieAnimationView.animate().translationX(2000).setDuration(2800).setStartDelay(1000);
        new Handler().
                postDelayed((Runnable) () -> {
            Intent intent=new Intent(getApplicationContext(),StartScreen.class);
            startActivity(intent);
        },10000);

    }
}