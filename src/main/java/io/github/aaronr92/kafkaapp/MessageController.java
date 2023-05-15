package io.github.aaronr92.kafkaapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<Void> publish(@RequestBody MessageRequest messageRequest) {
        kafkaTemplate.send("applicationTopic", messageRequest.message());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
