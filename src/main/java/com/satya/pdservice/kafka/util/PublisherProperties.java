package com.satya.pdservice.kafka.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.kafka.producer")
public class PublisherProperties {
    private String topic;
    private int kafkaPartition;
}
