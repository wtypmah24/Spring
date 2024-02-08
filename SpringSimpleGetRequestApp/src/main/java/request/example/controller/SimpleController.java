package request.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import request.example.service.SimpleService;

@Controller
public class SimpleController {
    private final SimpleService service;
    private final ObjectMapper mapper;

    @Autowired
    public SimpleController(SimpleService service, ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @PostMapping("/words")
    public String postMessages(@RequestBody String message){
        if (message == null || message.isEmpty()) return "/error";
        service.addMessage(message);
        return "/accepted";
    }
    @GetMapping(path = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getMessages() {
        try {
            return mapper.writeValueAsString(service.getMessages());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
