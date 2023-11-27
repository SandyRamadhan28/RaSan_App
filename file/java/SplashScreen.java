package com.example.helloappsti22a4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        ImageView logoImageView = findViewById(R.id.mdinalayubi_logo_transparant_2);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logoImageView.startAnimation(fadeIn);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Animation fadeOut = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.fade_out);
                logoImageView.startAnimation(fadeOut);

                fadeOut.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        logoImageView.setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(SplashScreen.this, MainHome.class);
                        startActivity(intent);

                        overridePendingTransition(R.anim.slide_in_form_right, R.anim.slide_out_to_left);

                        finish();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        }, 2500);
    }
}
