package com.satya.pdservice.kafka;

import com.satya.pdservice.model.Product;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    private final PublisherProperties publisherProperties;
    private final KafkaProducer<String, Product> kafkaProducer;
    public Publisher(@Autowired PublisherProperties publisherProperties, @Autowired KafkaProducer<String, Product> kafkaProducer) {
        this.publisherProperties = publisherProperties;
        this.kafkaProducer = kafkaProducer;
    }
    public String publish(Product product){
        kafkaProducer.send(new ProducerRecord<>
                (publisherProperties.getTopic(),
                        String.valueOf(product.getId()), product));
        return "Published Successfully";
    }
}
