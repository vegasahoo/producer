package com.satya.pdservice.kafka.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.satya.pdservice.model.Product;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomSerializer implements Serializer<Product> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public byte[] serialize(String topic, Product product) {
        try {
            if (product == null){
                logger.info("Null received at serializing");
                return null;
            }
            return objectMapper.writeValueAsBytes(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SerializationException("Error when serializing Product to byte[]");
        }
    }
}

