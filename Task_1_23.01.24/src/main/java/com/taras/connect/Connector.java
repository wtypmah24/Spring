package com.taras.connect;

import com.taras.props.ConnectionProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Connector {
    private final ConnectionProperties connectionProperties;

    @Autowired
    public Connector(ConnectionProperties connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    public void connect() {
        System.out.println("Try to connect with host " + connectionProperties.host() + " with port " + connectionProperties.port());

        try {
            Thread.sleep(500);
            System.out.println("\nSuccessfully connected.");
        } catch (InterruptedException e) {
            System.out.println("\nCan not connect.");
            throw new RuntimeException(e);
        }

    }
}
