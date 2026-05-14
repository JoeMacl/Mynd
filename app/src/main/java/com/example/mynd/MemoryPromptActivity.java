package com.example.mynd;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MemoryPromptActivity extends AppCompatActivity {

    private TextView promptText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_prompt);

        promptText = findViewById(R.id.promptText);

        SharedPreferences prefs = getSharedPreferences("MyndProfile", MODE_PRIVATE);

        String familyName = prefs.getString("family", "family");
        String hobby = prefs.getString("hobby", "gardening");
        String team = prefs.getString("team", "team");

        promptText.setText("Generating AI memory prompt...");

        generatePrompt(familyName, hobby, team);
    }

    private void generatePrompt(String family, String hobby, String team) {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, java.util.concurrent.TimeUnit.SECONDS)
                .readTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
                .writeTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
                .build();

        try {

            JSONObject json = new JSONObject();

            json.put("model", "llama3.2:latest");

            json.put("prompt",
                    "Generate only one short dementia-friendly memory recall question. " +
                            "Do not explain the question. Do not include extra commentary. " +
                            "Use this information: Family member: " + family +
                            ", Hobby: " + hobby +
                            ", Favourite team: " + team);

            json.put("stream", false);

            RequestBody body = RequestBody.create(
                    json.toString(),
                    MediaType.parse("application/json")
            );

            Request request = new Request.Builder()
                    .url("http://10.0.2.2:11434/api/generate")
                    .post(body)
                    .build();

            client.newCall(request).enqueue(new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(() ->
                            promptText.setText("Connection failed: " + e.getMessage())
                    );
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {

                    if (response.body() != null) {

                        String responseBody = response.body().string();
                        System.out.println(responseBody);

                        try {

                            JSONObject jsonResponse = new JSONObject(responseBody);

                            String aiResponse = jsonResponse.getString("response");

                            runOnUiThread(() ->
                                    promptText.setText(aiResponse)
                            );

                        } catch (Exception e) {
                            runOnUiThread(() ->
                                    promptText.setText("Response parsing failed")
                            );
                        }
                    }
                }
            });



        } catch (Exception e) {
            promptText.setText("Error generating prompt");
        }


    }

}