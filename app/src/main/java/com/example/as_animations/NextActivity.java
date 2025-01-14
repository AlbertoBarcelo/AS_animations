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

    }
}
