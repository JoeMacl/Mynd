package com.example.mynd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MemoryDetailsActivity extends AppCompatActivity {

    private EditText mealInput, jobInput, hobbyInput, teamInput, familyInput, relationshipInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_details);

        mealInput = findViewById(R.id.mealInput);
        jobInput = findViewById(R.id.jobInput);
        hobbyInput = findViewById(R.id.hobbyInput);
        teamInput = findViewById(R.id.teamInput);
        familyInput = findViewById(R.id.familyInput);
        relationshipInput = findViewById(R.id.relationshipInput);

        Button saveButton = findViewById(R.id.saveMemoryDetailsButton);

        saveButton.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("MyndProfile", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            editor.putString("meal", mealInput.getText().toString());
            editor.putString("job", jobInput.getText().toString());
            editor.putString("hobby", hobbyInput.getText().toString());
            editor.putString("team", teamInput.getText().toString());
            editor.putString("family", familyInput.getText().toString());
            editor.putString("relationship", relationshipInput.getText().toString());

            editor.apply();

            Toast.makeText(this, "Memory details saved", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MemoryDetailsActivity.this, MemoryPromptActivity.class);
            startActivity(intent);
        });
    }
}