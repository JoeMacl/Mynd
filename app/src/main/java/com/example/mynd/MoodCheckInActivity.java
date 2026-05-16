package com.example.mynd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MoodCheckInActivity extends AppCompatActivity {

    private TextView feedbackText;
    private Button continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_check_in);

        feedbackText = findViewById(R.id.feedbackText);
        continueButton = findViewById(R.id.continueButton);

        Button happyButton = findViewById(R.id.happyButton);
        Button okayButton = findViewById(R.id.okayButton);
        Button sadButton = findViewById(R.id.sadButton);

        continueButton.setEnabled(false);

        happyButton.setOnClickListener(v -> showFeedback("happy"));
        okayButton.setOnClickListener(v -> showFeedback("okay"));
        sadButton.setOnClickListener(v -> showFeedback("sad"));

        continueButton.setOnClickListener(v -> {
            Intent intent = new Intent(MoodCheckInActivity.this, MemoryPromptActivity.class);
            startActivity(intent);
        });
    }

    private void showFeedback(String mood) {
        if (mood.equals("happy")) {
            feedbackText.setText("That’s wonderful. Let’s enjoy a short memory activity together.");
        } else if (mood.equals("okay")) {
            feedbackText.setText("That’s okay. We’ll take this slowly and gently.");
        } else {
            feedbackText.setText("That’s alright. Take your time. This session will be calm and simple.");
        }

        continueButton.setEnabled(true);
    }
}