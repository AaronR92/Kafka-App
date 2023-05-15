package io.github.aaronr92.kafkaapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(KafkaTemplate<String, String> template) {
        return args -> {
            for (int i = 0; i < 100; i++) {
                template.send("applicationTopic", "hello kafka 👋 " + i);
            }
        };
    }

}
