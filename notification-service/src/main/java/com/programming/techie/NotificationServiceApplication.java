package com.programming.techie;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableDiscoveryClient
public class NotificationServiceApplication {

    private final ObservationRegistry observationRegistry;
    private final Tracer tracer;
    
    private final NotificationRepository notificationRepository;

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
        
        System.out.println("this is notification service man....");
    }

    @KafkaListener(topics = "orderTopic", groupId = "notificationGroup")
    public void handleNotification(OrderPlacedEvent event) {

        Notification notification = new Notification();
        notification.setOrderNumber(event.getOrderNumber());
        notification.setMessage("Order placed successfully");
        notification.setStatus("SENT");
        notification.setCreatedAt(LocalDateTime.now());

        notificationRepository.save(notification);

        log.info("Notification saved for order {}", event.getOrderNumber());
    }
}
