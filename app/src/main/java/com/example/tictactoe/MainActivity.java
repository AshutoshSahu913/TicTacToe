package com.example.tictactoe;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
//    ImageView flyO;

    //Animation declaration
    Animation zig_zag, blink;

    //lottie animation
    LottieAnimationView lottieAnimationView;

    //Linear layout declaration
    LinearLayout player1, player2;

    ImageView imageViewHome,imageViewRefresh;

    // Player representation
    // 0=X
    // 1=O
    int activePlayer = 0;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //State Meaning
    //0=X
    //1=O
    //2=Null
    int[][] winPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 7},
            {0, 4, 8}, {2, 4, 6}};

    Boolean gameActive = true;

    public void gameReset(View view) {
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 0;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

    }

    public void PlayerTap(View view) {
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
//        if (!gameActive) {
//            gameReset(view);
////            return;
//        }
        if (gameState[tappedImage] == 2) {
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);

            if (activePlayer == 1) {
                img.setImageResource(R.drawable.o);
                player1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.corner4));
                player2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.yellow));
                activePlayer = 0;
            } else {
                img.setImageResource(R.drawable.cancel);
                player1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.yellow));
                player2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.corner4));
                activePlayer = 1;

            }
            img.animate().translationYBy(1000f);

        }

        //check if any player has won
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[1]] == gameState[winPosition[2]] && gameState[winPosition[0]] != 2) {
                gameActive = false;
                //somebody has won
                if (gameState[winPosition[0]] == 0) {
                    Dialog dialog = new Dialog(this);
                    dialog.setContentView(R.layout.win1_dialog);
                    /*imageViewRefresh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gameReset(v);
                        }
                    });
                    imageViewHome.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i=new Intent(getApplicationContext(),Home.class);
                            startActivity(i);
                        }
                    });*/
                    dialog.show();

//                    Intent intent=new Intent(getApplicationContext(),WinningScreen.class);
//                    startActivity(intent);
//                    Toast.makeText(this, "X is win", Toast.LENGTH_SHORT).show();

                } else {
                    Dialog dialog = new Dialog(this);
                    dialog.setContentView(R.layout.win2_dialog);
                    /*imageViewRefresh.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                             gameReset(v);
                        }
                    });*/
                    dialog.show();

//                    Intent intent=new Intent(getApplicationContext(),WinningScreen.class);
//                    startActivity(intent);
//                    Toast.makeText(this, "O is win", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        //Home and refresh button
//        flyO = findViewById(R.id.flyO);
        //Animation
        zig_zag = AnimationUtils.loadAnimation(this, R.anim.zig_zag);
        blink = AnimationUtils.loadAnimation(this, R.anim.blink);

//        imageViewHome=findViewById(R.id.homeBtn);
//        imageViewRefresh=findViewById(R.id.refreshBtn);
//        flyO.setAnimation(zig_zag);
        //Linear layout
        player1 = findViewById(R.id.player1Layout);
        player2 = findViewById(R.id.player2Layout);

//        lottieAnimationView=findViewById(R.id.winning_match);
//        lottieAnimationView.animate();

        player1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.corner4));
    }
}
