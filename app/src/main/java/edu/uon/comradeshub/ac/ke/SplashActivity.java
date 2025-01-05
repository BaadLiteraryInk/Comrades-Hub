package edu.uon.comradeshub.ac.ke;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private ImageView splashImage;
    private TextView splashText1, splashText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Get references to the UI elements
        splashImage = findViewById(R.id.splashImage);
        splashText1 = findViewById(R.id.splashText1);
        splashText2 = findViewById(R.id.splashText2);

        // Animate Image with fade-in effect (Slow Fade-in)
        splashImage.setAlpha(0f); // Start as invisible
        splashImage.animate().alpha(1f).setDuration(3500).start(); // Fade-in over 3 seconds

        // Animate Text 1 (Slide from left to right)
        Animation textAnimation1 = AnimationUtils.loadAnimation(this, R.anim.text_animation_1);
        splashText1.startAnimation(textAnimation1);

        // Animate Text 2 (Fade-in)
        Animation textAnimation2 = AnimationUtils.loadAnimation(this, R.anim.text_animation_2);
        splashText2.startAnimation(textAnimation2);

        // Set a delay before transitioning to the next activity (MainActivity)
        splashImage.postDelayed(() -> {
            // Start MainActivity after the splash screen
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);

            // Apply custom slide-in transition
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            // Close SplashActivity so it is not in the backstack
            finish();
        }, 5000); // Delay to match the total duration of animations (adjustable)
    }
}
