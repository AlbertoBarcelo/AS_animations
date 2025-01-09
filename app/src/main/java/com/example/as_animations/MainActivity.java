package com.example.as_animations;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private boolean allAnimationsFinished = false; // Marca si todas las animaciones han terminado
    private boolean hasNavigated = false; // Evita múltiples navegaciones
    private int animationsCompleted = 0; // Contador para rastrear las animaciones completadas

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Carga la animación para las imágenes (custom_anim)
        Animation spinIn = AnimationUtils.loadAnimation(this, R.anim.custom_anim);

        // Listener para detectar el final de cada animación en las imágenes
        spinIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Opcional: Código que se ejecuta al inicio de cada animación
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animationsCompleted++; // Incrementa el contador de animaciones completadas
                checkAllAnimationsCompleted();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Opcional: Código que se ejecuta si la animación se repite
            }
        });

        // Encuentra el TableLayout en el diseño
        TableLayout table = findViewById(R.id.tableLayout01);

        // Crea un controlador de animación para aplicar custom_anim a cada fila del TableLayout
        LayoutAnimationController controller = new LayoutAnimationController(spinIn, 0.5f);

        // Aplica el controlador de animación a cada TableRow dentro del TableLayout
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            row.setLayoutAnimation(controller);
        }

        // Inicia las animaciones del TableLayout
        table.startLayoutAnimation();

        // **Segunda parte del título**
        TextView secondPartTitle = findViewById(R.id.textViewBottomTitle);

        // Carga la animación fade_in para la segunda parte del título
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in2);

        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Opcional: Código para ejecutar al inicio de la animación
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animationsCompleted++; // Incrementa el contador de animaciones completadas
                checkAllAnimationsCompleted();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Opcional: Código para ejecutar si la animación se repite
            }
        });

        // Aplica la animación fade_in al título inferior
        secondPartTitle.startAnimation(fadeIn);
    }

    private void checkAllAnimationsCompleted() {
        // Verifica si todas las animaciones han terminado y si aún no se ha navegado
        if (animationsCompleted >= 2 && !hasNavigated) { // Dos animaciones (imágenes y título)
            allAnimationsFinished = true;

            // Marca que ya se ha navegado para evitar múltiples ejecuciones
            hasNavigated = true;

            // Agrega un retardo de 2 segundos antes de navegar a la siguiente actividad
            new Handler().postDelayed(() -> navigateToNextActivity(), 2000);
        }
    }

    private void navigateToNextActivity() {
        if (allAnimationsFinished) {
            Intent intent = new Intent(MainActivity.this, NextActivity.class);
            startActivity(intent);
            finish(); // Finaliza la actividad actual para que no vuelva al presionar "Atrás"
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Encuentra el TableLayout y detiene las animaciones en onPause()
        TableLayout table = findViewById(R.id.tableLayout01);
        for (int i = 0; i < table.getChildCount(); i++) {
            TableRow row = (TableRow) table.getChildAt(i);
            row.clearAnimation();
        }

        // Detiene la animación del título inferior
        TextView secondPartTitle = findViewById(R.id.textViewBottomTitle);
        secondPartTitle.clearAnimation();
    }
}
