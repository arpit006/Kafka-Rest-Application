package io.app.kafka.framework.configuration.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;

import java.util.Properties;

/**
 * Configuration class for configuring properties for Kafka Consumer.
 *
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@EnableKafka
@Configuration
@PropertySource("classpath:kafka.properties")
public class ConsumerConfiguration {

    @Value("${kafka.consumer.bootstrapServer}")
    private String bootstrapServers;

    @Value("${kafka.consumer.keyDeserializer}")
    private String keyDeserializer;

    @Value("${kafka.consumer.valueDeserializer}")
    private String valueDeserializer;

    @Value("${kafka.consumer.groupId}")
    private String groupId;

    @Value("${kafka.consumer.autoResetOffset}")
    private String autoKeyOffsetReset;

    @Bean
    public KafkaConsumer<String, String> kafkaConsumer() {
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoKeyOffsetReset);
        properties.setProperty(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, "10000");
        properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "100");
        properties.setProperty(ConsumerConfig.MAX_PARTITION_FETCH_BYTES_CONFIG, "100");
        properties.setProperty(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, "100");
        return new KafkaConsumer<>(properties);
    }
}
