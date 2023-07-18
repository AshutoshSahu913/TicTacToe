package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class StartScreen extends AppCompatActivity {
    ImageView img1, startImg,img2,img3,img4,img5,rocket_img;
    Animation animZoom, animTrans,animTrans2,rocket;
    LinearLayout l1, l2, l3;
    LottieAnimationView lottieAnimationView;

    private static final int DELAY = 3000;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_start_screen);
        animZoom = AnimationUtils.loadAnimation(this, R.anim.zoom);
        animTrans = AnimationUtils.loadAnimation(this, R.anim.right_to_left);
        animTrans2 = AnimationUtils.loadAnimation(this, R.anim.left_to_right);
        rocket = AnimationUtils.loadAnimation(this, R.anim.rocket);
        rocket_img=findViewById(R.id.rocket);
//        lottieAnimationView=findViewById(R.id.oxAnim);
//        lottieAnimationView.animate();
        startImg = findViewById(R.id.startBtn);
      /*
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);

        img1.animate().setStartDelay(2000).translationX(-100);
//        img1.setAnimation(animZoom);
        img2.animate().setStartDelay(4000);
//        img2.setAnimation(animTrans2);
        img3.animate().setStartDelay(6000);
//        img3.setAnimation(animZoom);
        img4.animate().setStartDelay(8000);
//        img4.setAnimation(animTrans2);
        img5.animate().setStartDelay(10000);
//        img5.setAnimation(animZoom);
*/
        l1 = findViewById(R.id.tic_liner);
        l2 = findViewById(R.id.tac_liner);
        l3 = findViewById(R.id.toe_liner);
        l1.animate().setStartDelay(1000);
        l1.setAnimation(animTrans);
        l2.animate().setStartDelay(4000);
        l2.setAnimation(animTrans2);
        l3.animate().setStartDelay(8000);
        l3.setAnimation(animTrans);
//        l1.animate().translationX(-1000).setStartDelay(100).setDuration(2000);

        rocket_img.setAnimation(rocket);

        startImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(intent);
            }
        });

    }
}