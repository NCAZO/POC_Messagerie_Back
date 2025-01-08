package com.openclassrooms.poc.dto.response;

import com.openclassrooms.poc.models.ChatMessage;

import java.util.List;

public class ChatMessageResponseDto {
    private List<ChatMessage> messages;

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }
}
