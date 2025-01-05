package edu.uon.comradeshub.ac.ke;

import java.util.List;

public class ChatGPTResponse {

    private List<Choice> choices;

    public List<Choice> getChoices() {
        return choices;
    }

    public static class Choice {
        private String text;

        public String getText() {
            return text;
        }
    }
}
