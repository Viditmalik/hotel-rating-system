package com.micro.hotel.kafka;

import com.micro.hotel.events.RatingCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(
            topics = "rating-created-topic",
            groupId = "hotel-group"
    )
    public void consume(RatingCreatedEvent event) {

        System.out.println("================================");
        System.out.println("Rating Event Consumed");
        System.out.println(event);
        System.out.println("================================");
    }
}