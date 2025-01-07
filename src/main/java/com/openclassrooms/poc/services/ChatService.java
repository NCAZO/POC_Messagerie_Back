package com.openclassrooms.poc.services;

import com.openclassrooms.poc.dto.request.ChatRequestDto;
import com.openclassrooms.poc.models.ChatMessage;
import com.openclassrooms.poc.models.User;
import com.openclassrooms.poc.repository.ChatRepository;
import com.openclassrooms.poc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public ChatService(ChatRepository chatRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    public ChatMessage sendMessage(ChatRequestDto chatRequestDto) {

        String username = chatRequestDto.getUsername();
        Optional<User> user = userRepository.findByName(username);

        if (user.isPresent()) {
            ChatMessage newMessage = new ChatMessage();
            newMessage.setContent(chatRequestDto.getMessage());
            newMessage.setUser_id(user.get().getId());
            newMessage.setCreated_at(new Date());

            return chatRepository.save(newMessage);
        } else {
            // Gérer le cas où l'utilisateur n'existe pas
            throw new RuntimeException("Utilisateur non trouvé");
        }
    }

}
