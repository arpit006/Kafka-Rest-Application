package io.app.kafka.example;

import io.app.kafka.framework.consumer.BaseConsumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Component
public class BusinessConsumer extends BaseConsumer<String> {

    private static String inTopic;

    static {
        inTopic = "business_topic_1";
    }

    private final KafkaConsumer<String, String> consumer;

    public BusinessConsumer(KafkaConsumer<String, String> consumer) {
        super(consumer, inTopic);
        this.consumer = consumer;
    }
}
