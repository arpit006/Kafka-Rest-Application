package io.app.kafka.example1;

import io.app.kafka.framework.consumer.BaseConsumer;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Component
public class EmployeeConsumer extends BaseConsumer<String, String> {

    private static String inTopic;

    static {
        inTopic = "employee_topic";
    }

    private KafkaConsumer<String, String> kafkaConsumer;

    public EmployeeConsumer(KafkaConsumer<String, String> kafkaConsumer) {
        super(kafkaConsumer, inTopic);
        this.kafkaConsumer = kafkaConsumer;
    }
}
