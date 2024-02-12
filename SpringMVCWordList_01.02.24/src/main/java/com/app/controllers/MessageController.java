package com.app.controllers;

import com.app.service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {
    private MessageService messageService;
    private ObjectMapper objectMapper;

    @Autowired
    public MessageController(MessageService messageService, ObjectMapper objectMapper) {
        this.messageService = messageService;
        this.objectMapper = objectMapper;
    }


    @GetMapping(path = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getMessages() {
        try {
            return objectMapper.writeValueAsString(messageService.getMessages());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/messages")
    public String postMessage(@RequestBody String message){
        if (message == null || message.isEmpty()) return "/error";
        messageService.addMessage(message);
        return "/accepted";
    }
}