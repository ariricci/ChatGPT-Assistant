package com.chatgpt.entity;

public class Choices {

    ChatGptMessage message;
    String finish_reason;
    Integer index;

    public ChatGptMessage getMessage() {
        return message;
    }

    public void setMessage(ChatGptMessage message) {
        this.message = message;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}

