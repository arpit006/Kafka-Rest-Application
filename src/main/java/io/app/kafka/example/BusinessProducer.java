package io.app.kafka.example;

import io.app.kafka.framework.producer.BaseProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Component
public class BusinessProducer extends BaseProducer<String, String   > {

    private static String inTopic;

    static {
        inTopic = "business_topic_2";
    }

    private final
    KafkaTemplate<String, String> kafkaTemplate;

    public BusinessProducer(KafkaTemplate<String, String> kafkaTemplate) {
        super(kafkaTemplate, inTopic);
        this.kafkaTemplate = kafkaTemplate;
    }
}
