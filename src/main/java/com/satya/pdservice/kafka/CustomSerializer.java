package com.satya.pdservice.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.satya.pdservice.model.Product;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CustomSerializer implements Serializer<Product> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }

    @Override
    public byte[] serialize(String topic, Product product) {
        try {
            if (product == null){
                System.out.println("Null received at serializing");
                return null;
            }
            return objectMapper.writeValueAsBytes(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new SerializationException("Error when serializing Product to byte[]");
        }
    }

    @Override
    public void close() {
    }
}

