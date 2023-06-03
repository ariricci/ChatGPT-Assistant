package com.chatgpt.entity;

import java.util.ArrayList;
import java.util.List;

public class ChatGptRequestParameter {

    String model = "gpt-3.5-turbo";

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<ChatGptMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatGptMessage> messages) {
        this.messages = messages;
    }

    List<ChatGptMessage> messages = new ArrayList<>();

    public void addMessages(ChatGptMessage message) {
        this.messages.add(message);
    }

}
