package com.example.mynd;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MemoryPromptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_prompt);

        TextView promptText = findViewById(R.id.promptText);

        SharedPreferences prefs = getSharedPreferences("MyndProfile", MODE_PRIVATE);

        String familyName = prefs.getString("family", "your family member");
        String relationship = prefs.getString("relationship", "family");

        String question = "Who is " + familyName + "?";

        promptText.setText(question);
    }
}