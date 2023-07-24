package com.satya.pdservice.model;

import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.common.serialization.Serializer;


@Getter
@Setter
public class Product implements Serializer {

    private int id;
    private int price;
    private String code;

    private Brand brand;
    private Color color;
    private Category category;

    @Override
    public byte[] serialize(String topic, Object data) {
        return new byte[0];
    }
}
