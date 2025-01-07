package com.openclassrooms.poc.controllers;

import com.openclassrooms.poc.dto.response.MessageResponseDto;
import com.openclassrooms.poc.models.User;
import com.openclassrooms.poc.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/join")
    public ResponseEntity<MessageResponseDto> join(@RequestBody String username) {
        try {
            User user = userService.join(username);
            MessageResponseDto messageResponseDto = new MessageResponseDto("User joined!");
            return ResponseEntity.ok().body(messageResponseDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new MessageResponseDto(e.getMessage()));
        }
    }

    @PostMapping("/disconnect")
    public ResponseEntity<MessageResponseDto> disconnect(@RequestBody String username) {
        try {
            userService.disconnect(username);
            MessageResponseDto messageResponseDto = new MessageResponseDto("User disconnected!");
            return ResponseEntity.ok(messageResponseDto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new MessageResponseDto("Erreur : " + e.getMessage()));
        }
    }

}
