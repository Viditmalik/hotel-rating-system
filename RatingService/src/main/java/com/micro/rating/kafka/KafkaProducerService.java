package com.micro.rating.kafka;

import com.micro.rating.events.RatingCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "rating-created-topic";

    private final KafkaTemplate<String, RatingCreatedEvent> kafkaTemplate;

    public KafkaProducerService(
            KafkaTemplate<String, RatingCreatedEvent> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishRatingCreatedEvent(
            RatingCreatedEvent event) {

        kafkaTemplate.send(
                TOPIC,
                event.getHotelId(),
                event
        );

        System.out.println(
                "Rating Event Published : "
                        + event.getRatingId()
        );
    }

}