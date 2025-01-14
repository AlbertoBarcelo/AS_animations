package com.example.as_animations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NextActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        // Lista de opciones
        ListView menuList = findViewById(R.id.ListView_Menu);

        // Opciones del menú
        String[] items = {
                getString(R.string.menu_item_play),
                getString(R.string.menu_item_scores),
                getString(R.string.menu_item_settings),
                getString(R.string.menu_item_help)
        };

        // Adaptador
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.menu_item, items);
        menuList.setAdapter(adapter);
/*
        // Manejar clics en los elementos del menú
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0: // Play Game
                        intent = new Intent(QuizMenuActivity.this, QuizGameActivity.class);
                        break;
                    case 1: // View Scores
                        intent = new Intent(QuizMenuActivity.this, QuizScoresActivity.class);
                        break;
                    case 2:
                        intent = new Intent(QuizMenuActivity.this, QuizSettingsActivity.class);
                        break;
                    case 3: // Help
                        intent = new Intent(QuizMenuActivity.this, QuizHelpActivity.class);
                        break;
                    default:
                        return;
                }
                startActivity(intent);
            }
        });

 */
    }
}
