package com.satya.pdservice.controller;

import com.satya.pdservice.kafka.publisher.Publisher;
import com.satya.pdservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    private final Publisher publisher;

    public PublisherController(@Autowired Publisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/health-check")
    public String healthCheck(){
        return "alive";
    }

    @GetMapping("/publish")
    public String publishMessage(@RequestBody Product message){
        return publisher.publish(message);
    }
}
