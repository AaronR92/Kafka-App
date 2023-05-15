package io.github.aaronr92.kafkaapp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    Logger logger = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(
            topics = "applicationTopic",
            groupId = "appGroup"
    )
    void listener(String data) {
        logger.info("Listener received: {} 🎉", data);
    }

}
