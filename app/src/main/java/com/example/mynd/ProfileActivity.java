package com.example.mynd;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private EditText nameInput, ageInput, sexInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameInput = findViewById(R.id.nameInput);
        ageInput = findViewById(R.id.ageInput);
        sexInput = findViewById(R.id.sexInput);

        Button saveButton = findViewById(R.id.saveProfileButton);

        saveButton.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("MyndProfile", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            editor.putString("name", nameInput.getText().toString());
            editor.putString("age", ageInput.getText().toString());
            editor.putString("sex", sexInput.getText().toString());

            editor.apply();

            Toast.makeText(this, "Patient profile saved", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(ProfileActivity.this, MemoryDetailsActivity.class);
            startActivity(intent);
        });
    }
}