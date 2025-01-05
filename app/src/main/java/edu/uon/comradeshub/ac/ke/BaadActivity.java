package edu.uon.comradeshub.ac.ke;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaadActivity extends AppCompatActivity {

    private static final String TAG = "ChatGPTIntegration";
    private EditText inputText;
    private Button sendButton;
    private TextView responseTextView;

    private static final String OPENAI_API_KEY ="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"; // Keep your key secure

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baad);

        inputText = findViewById(R.id.inputText);
        sendButton = findViewById(R.id.sendButton);
        responseTextView = findViewById(R.id.responseTextView);

        sendButton.setOnClickListener(v -> {
            String userInput = inputText.getText().toString().trim();

            if (!userInput.isEmpty()) {
                List<ChatGPTRequest.Message> messages = new ArrayList<>();
                messages.add(new ChatGPTRequest.Message("user", userInput));

                // Adding a system message for context
                messages.add(0, new ChatGPTRequest.Message("system", "You are a helpful assistant."));

                ChatGPTRequest request = new ChatGPTRequest("gpt-3.5-turbo", messages);
                makeChatGPTRequest(request);
            }
        });
    }

    private void makeChatGPTRequest(ChatGPTRequest request) {
        OpenAIService openAIService = RetrofitClient.getRetrofitInstance().create(OpenAIService.class);

        Call<ChatGPTResponse> call = openAIService.getChatGPTResponse(request);

        call.enqueue(new Callback<ChatGPTResponse>() {
            @Override
            public void onResponse(Call<ChatGPTResponse> call, Response<ChatGPTResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String chatGPTResponse = response.body().getChoices().get(0).getText();
                    responseTextView.setText(chatGPTResponse);
                    Log.d(TAG, "ChatGPT Response: " + chatGPTResponse);
                } else {
                    try {
                        String errorBody = response.errorBody() != null ? response.errorBody().string() : "Unknown error";
                        Log.e(TAG, "Request failed: " + errorBody);
                        responseTextView.setText("Error: " + errorBody);
                    } catch (Exception e) {
                        Log.e(TAG, "Error reading the error response: " + e.getMessage());
                        responseTextView.setText("Error: " + e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<ChatGPTResponse> call, Throwable t) {
                Log.e(TAG, "API Call failed: " + t.getMessage());
                responseTextView.setText("Error: " + t.getMessage());
            }
        });
    }
}
