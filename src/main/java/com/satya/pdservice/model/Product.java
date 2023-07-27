package com.satya.pdservice.model;

import lombok.*;
import org.apache.kafka.common.serialization.Serializer;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    private int id;
    private int price;
    private String code;
    private Brand brand;
    private Color color;
    private Category category;
}
