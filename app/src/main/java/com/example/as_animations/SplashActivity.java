package com.example.as_animations;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Encuentra las vistas del diseño
        ImageView splashImage = findViewById(R.id.splashImageView);
        TextView splashTitle = findViewById(R.id.splashTitle);

        // Carga y aplica la animación para la imagen
        Animation imageAnimation = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        splashImage.startAnimation(imageAnimation);



        // Retardo de 3 segundos antes de navegar a MainActivity
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Finaliza SplashActivity para que no regrese al presionar "Atrás"
        }, 3000); // 3000ms = 3 segundos
    }
}
