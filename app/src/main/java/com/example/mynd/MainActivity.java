package com.example.mynd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView profileText = findViewById(R.id.profileText);

        Button createProfileButton = findViewById(R.id.createProfileButton);
        Button startMemoryButton = findViewById(R.id.startMemoryButton);
        Button editMemoryButton = findViewById(R.id.editMemoryButton);

        SharedPreferences prefs = getSharedPreferences("MyndProfile", MODE_PRIVATE);

        String name = prefs.getString("name", "");

        if (!name.isEmpty()) {
            profileText.setText("Current Patient: " + name);
        }

        createProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        startMemoryButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MoodCheckInActivity.class);
            startActivity(intent);
        });

        editMemoryButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MemoryDetailsActivity.class);
            startActivity(intent);
        });
    }
}