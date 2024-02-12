package com.app.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private final List<String> messages;

    public MessageService() {
        messages = new ArrayList<>();
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
    public void addMessage(String input){
        messages.add(input);
    }
}