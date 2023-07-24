package com.satya.pdservice.kafka;

import com.satya.pdservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    private final PublisherProperties publisherProperties;
    private final KafkaTemplate<String, Product> kafkaTemplate;
    @Autowired
    public Publisher(PublisherProperties publisherProperties, KafkaTemplate<String, Product> kafkaTemplate) {
        this.publisherProperties = publisherProperties;
        this.kafkaTemplate = kafkaTemplate;
    }
    public String publish(Product product){
        kafkaTemplate.send(publisherProperties.getTopic(), publisherProperties.getKafkaPartition(),
                String.valueOf(product.getId()), product);
        return "Published Successfully";
    }
}
