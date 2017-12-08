package com.teste.kafkapoc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class SimpleController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleController.class);


    @KafkaListener(topics = "fila")
    public void listen(@Payload String foo,
            @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        LOGGER.info("Key: {}, toppic: {}, partition: {}, payload: {}", key, topic, partition, foo);
    }
}
