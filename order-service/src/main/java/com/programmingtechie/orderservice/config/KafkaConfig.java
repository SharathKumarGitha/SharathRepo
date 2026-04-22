//package com.programmingtechie.orderservice.config;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.kafka.clients.producer.ProducerConfig;
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.TopicBuilder;
//import org.springframework.kafka.core.DefaultKafkaProducerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.core.ProducerFactory;
//import org.springframework.kafka.support.serializer.JsonSerializer;
//
//import com.programmingtechie.orderservice.dto.OrderPlacedEvent;
//
//@Configuration
//public class KafkaConfig {
//
//	@Bean
//	public ProducerFactory<String, OrderPlacedEvent> producerFactory() {
//
//		Map<String, Object> config = new HashMap<>();
//
//		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//
//		return new DefaultKafkaProducerFactory<>(config);
//	}
//
//	@Bean
//	public KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate() {
//		return new KafkaTemplate<>(producerFactory());
//	}
//
//	@Bean
//	public NewTopic orderTopic() {
//		return TopicBuilder.name("orderTopic").partitions(3).replicas(1).build();
//	}
//}