package com.openclassrooms.poc.services;

import com.openclassrooms.poc.models.User;
import com.openclassrooms.poc.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User join(String username) {
        Optional<User> user = userRepository.findByName(username);

        if (user.isPresent()) {
            throw new RuntimeException("Utilisateur déjà existant !");
        } else {
            User newUser = new User();
            newUser.setName(username);

            return userRepository.save(newUser);
        }
    }

    public void disconnect(String username) {
        Optional<User> user = userRepository.findByName(username);

        if (user.isPresent()) {
            userRepository.delete(user.get());
        } else {
            throw new RuntimeException("Utilisateur non trouvé !");
        }
    }

}
