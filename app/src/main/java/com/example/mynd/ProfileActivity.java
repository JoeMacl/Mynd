package com.example.mynd;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private EditText nameInput, familyInput, relationshipInput, hobbyInput, teamInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameInput = findViewById(R.id.nameInput);
        familyInput = findViewById(R.id.familyInput);
        relationshipInput = findViewById(R.id.relationshipInput);
        hobbyInput = findViewById(R.id.hobbyInput);
        teamInput = findViewById(R.id.teamInput);

        Button saveButton = findViewById(R.id.saveProfileButton);

        saveButton.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("MyndProfile", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            editor.putString("name", nameInput.getText().toString());
            editor.putString("family", familyInput.getText().toString());
            editor.putString("relationship", relationshipInput.getText().toString());
            editor.putString("hobby", hobbyInput.getText().toString());
            editor.putString("team", teamInput.getText().toString());

            editor.apply();

            Toast.makeText(this, "Profile saved", Toast.LENGTH_SHORT).show();
        });
    }
}