package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class WinningScreen extends AppCompatActivity {

    Animation rocket;
    ImageView rocketGo;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_screen);
        getSupportActionBar().hide();
        rocketGo=findViewById(R.id.rocketGo);
        rocket= AnimationUtils.loadAnimation(this,R.anim.rocket);

        rocketGo.setAnimation(rocket);

    }
}