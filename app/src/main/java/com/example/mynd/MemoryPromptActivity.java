package com.example.mynd;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MemoryPromptActivity extends AppCompatActivity {

    private TextView promptText;
    private TextView feedbackText;

    private Button optionOneButton;
    private Button optionTwoButton;
    private Button optionThreeButton;

    private String correctAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_prompt);

        promptText = findViewById(R.id.promptText);
        feedbackText = findViewById(R.id.feedbackText);

        optionOneButton = findViewById(R.id.optionOneButton);
        optionTwoButton = findViewById(R.id.optionTwoButton);
        optionThreeButton = findViewById(R.id.optionThreeButton);

        Button nextQuestionButton = findViewById(R.id.nextQuestionButton);

        loadQuestion();

        nextQuestionButton.setOnClickListener(v -> {
            feedbackText.setText("");
            loadQuestion();
        });

        Button homeButton = findViewById(R.id.homeButton);

        homeButton.setOnClickListener(v -> {
            finish();
        });
    }

    private void loadQuestion() {

        SharedPreferences prefs = getSharedPreferences("MyndProfile", MODE_PRIVATE);

        String hobby = prefs.getString("hobby", "Gardening");
        String team = prefs.getString("team", "Cats");
        String meal = prefs.getString("meal", "Pizza");
        String job = prefs.getString("job", "Teacher");

        int questionType = (int) (Math.random() * 4);

        switch (questionType) {

            case 0:
                promptText.setText("What hobby do you enjoy?");
                correctAnswer = hobby;

                optionOneButton.setText(hobby);
                optionTwoButton.setText("Fishing");
                optionThreeButton.setText("Cooking");
                break;

            case 1:
                promptText.setText("Which team do you support?");
                correctAnswer = team;

                optionOneButton.setText("Lions");
                optionTwoButton.setText(team);
                optionThreeButton.setText("Bombers");
                break;

            case 2:
                promptText.setText("What is your favourite meal?");
                correctAnswer = meal;

                optionOneButton.setText("Pasta");
                optionTwoButton.setText("Salad");
                optionThreeButton.setText(meal);
                break;

            case 3:
                promptText.setText("What was your first job?");
                correctAnswer = job;

                optionOneButton.setText(job);
                optionTwoButton.setText("Chef");
                optionThreeButton.setText("Driver");
                break;
        }

        optionOneButton.setOnClickListener(v -> checkAnswer(optionOneButton.getText().toString()));

        optionTwoButton.setOnClickListener(v -> checkAnswer(optionTwoButton.getText().toString()));

        optionThreeButton.setOnClickListener(v -> checkAnswer(optionThreeButton.getText().toString()));
    }

    private void checkAnswer(String selectedAnswer) {

        if (selectedAnswer.equals(correctAnswer)) {

            feedbackText.setText("Great job. That is correct.");

        } else {

            feedbackText.setText("That’s okay. The correct answer is " + correctAnswer + ".");
        }
    }
}