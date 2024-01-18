package com.taras.spam.senders;

import com.taras.interfaces.MessageGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    MessageGenerator messageGenerator;
    @Autowired
    public EmailSender(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
    }
    public MessageGenerator getMessageGenerator() {
        return messageGenerator;
    }
}