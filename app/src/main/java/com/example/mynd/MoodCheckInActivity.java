package com.example.mynd;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MoodCheckInActivity extends AppCompatActivity {

    private TextView feedbackText;
    private boolean moodSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_check_in);

        feedbackText = findViewById(R.id.feedbackText);

        Button happyButton = findViewById(R.id.happyButton);
        Button okayButton = findViewById(R.id.okayButton);
        Button sadButton = findViewById(R.id.sadButton);

        happyButton.setOnClickListener(v -> showFeedback("happy"));
        okayButton.setOnClickListener(v -> showFeedback("okay"));
        sadButton.setOnClickListener(v -> showFeedback("sad"));
    }

    private void showFeedback(String mood) {

        if (moodSelected) {
            return;
        }

        moodSelected = true;

        getSharedPreferences("MyndProfile", MODE_PRIVATE)
                .edit()
                .putString("todayMood", mood)
                .apply();

        findViewById(R.id.moodTitleText).setVisibility(View.GONE);
        findViewById(R.id.happyButton).setVisibility(View.GONE);
        findViewById(R.id.okayButton).setVisibility(View.GONE);
        findViewById(R.id.sadButton).setVisibility(View.GONE);

        feedbackText.setVisibility(View.VISIBLE);

        if (mood.equals("happy")) {
            feedbackText.setText("That’s wonderful. Let’s enjoy a short memory activity together.");
        } else if (mood.equals("okay")) {
            feedbackText.setText("That’s okay. We’ll take this slowly and gently.");
        } else {
            feedbackText.setText("That’s alright. Take your time. This session will be calm and simple.");
        }

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(MoodCheckInActivity.this, MemoryPromptActivity.class);
            startActivity(intent);
            finish();
        }, 5000);
    }
}