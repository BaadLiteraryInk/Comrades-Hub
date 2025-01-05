package edu.uon.comradeshub.ac.ke;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface OpenAIService {

    @Headers({
            "Content-Type: application/json",
            "Authorization: Bearer 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"
    })

    @POST("v1/chat/completions")
    Call<ChatGPTResponse> getChatGPTResponse(@Body ChatGPTRequest request);
}

