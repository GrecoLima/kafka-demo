package com.greco.demokafka.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MeuTopicoConsumer {

    private final List<String> messages = new ArrayList<>();

    @Service
    public class SimpleConsumer {
      @KafkaListener(id = "simple-consumer", topics = "meu-topico")
      public void consumeMessage(String message) {
        System.out.println("Got message: " + message);
      }
    }

    public List<String> getMessages() {
        return messages;
    }

}