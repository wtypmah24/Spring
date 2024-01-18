package com.taras.message.generator;

import com.taras.interfaces.MessageGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
@Component
@Scope("prototype")
public class MessageGeneratorImpl implements MessageGenerator {
    private static int id = 1;
    @Override
    public void generateUniqueMsg() {
        System.out.println("Message number: " + (id++) + " -- at --  " + LocalTime.now());
    }
}