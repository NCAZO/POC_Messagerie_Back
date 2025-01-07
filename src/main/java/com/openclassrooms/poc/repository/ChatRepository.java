package com.openclassrooms.poc.repository;

import com.openclassrooms.poc.models.ChatMessage;
import com.openclassrooms.poc.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  ChatRepository extends JpaRepository<ChatMessage, Long> {
}
