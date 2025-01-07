package com.openclassrooms.poc.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MessageResponseDto {
    private String message;

    public MessageResponseDto(String message) {
        this.message = message;
    }

}