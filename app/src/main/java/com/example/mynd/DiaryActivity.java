package com.example.mynd;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DiaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        Button homeButton = findViewById(R.id.homeButton);

        homeButton.setOnClickListener(v -> {
            finish();
        });

        TextView diaryText = findViewById(R.id.diaryText);

        SharedPreferences prefs = getSharedPreferences("MyndProfile", MODE_PRIVATE);

        String entries = prefs.getString(
                "diaryEntries",
                "No diary entries yet."
        );

        diaryText.setText(entries);
    }
}