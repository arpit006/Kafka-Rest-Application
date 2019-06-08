package io.app.kafka.example1;

import io.app.kafka.framework.producer.BaseProducer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Component
public class EmployeeProducer extends BaseProducer<String, String> {

    private static String inTopic;

    static {
        inTopic = "employee_topic";
    }

    private KafkaTemplate<String, String> kafkaTemplate;

    public EmployeeProducer(KafkaTemplate<String, String> kafkaTemplate) {
        super(kafkaTemplate, inTopic);
        this.kafkaTemplate = kafkaTemplate;

    }
}
