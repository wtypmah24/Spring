package request.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleService {
    private final List<String> messages;

    public SimpleService() {
        messages = new ArrayList<>();
    }
    public void addMessage(String message){
        messages.add(message);
    }

    public List<String> getMessages(){
        return new ArrayList<>(messages);
    }

}
