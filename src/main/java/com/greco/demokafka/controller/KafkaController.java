package com.greco.demokafka.controller;

import java.util.List;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greco.demokafka.consumer.MeuTopicoConsumer;

@RestController
public class KafkaController {

    private KafkaTemplate<String, String> template;
    private MeuTopicoConsumer meuTopicoConsumer;

    public KafkaController(KafkaTemplate<String, String> template, MeuTopicoConsumer meuTopicoConsumer) {
        this.template = template;
        this.meuTopicoConsumer = meuTopicoConsumer;
    }

    @GetMapping("/kafka/produce")
    public void produce(@RequestParam String message) {
        template.send("meu-topico", message);
    }

    @GetMapping("/kafka/messages")
    public List<String> getMessages() {
        return meuTopicoConsumer.getMessages();
    }

}
