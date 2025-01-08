package com.openclassrooms.poc.controllers;

import com.openclassrooms.poc.dto.request.ChatRequestDto;
import com.openclassrooms.poc.dto.response.ChatMessageResponseDto;
import com.openclassrooms.poc.dto.response.MessageResponseDto;
import com.openclassrooms.poc.models.ChatMessage;
import com.openclassrooms.poc.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/sendMessage")
    public ResponseEntity<MessageResponseDto> sendMessage(@RequestBody ChatRequestDto chatRequestDto){

        ChatMessage chatMessage = chatService.sendMessage(chatRequestDto);

        // Réponse
        MessageResponseDto messageResponseDto = new MessageResponseDto("Message envoyé!");
        return ResponseEntity.ok(messageResponseDto);
    }

    @GetMapping("/getMessages")
    public ResponseEntity<ChatMessageResponseDto> getMessages() {
        ChatMessageResponseDto chatMessageResponseDto = new ChatMessageResponseDto();
        chatMessageResponseDto.setMessages(chatService.getMessages());
        return ResponseEntity.ok(chatMessageResponseDto);
    }
}
