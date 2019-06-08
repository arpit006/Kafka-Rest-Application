package io.app.kafka.framework.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;

/**
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public class BaseConsumer<K, V> {

    private static final Logger _logger = LoggerFactory.getLogger(BaseConsumer.class);

    private final String inTopic;

    private final KafkaConsumer<K, V> consumer;


    public BaseConsumer(KafkaConsumer<K, V> consumer, String inTopic) {
        this.inTopic = inTopic;
        this.consumer = consumer;
    }

    /**
     * This method consumes whatever is posted to that kafka topic.
     */
    public void consume() {
        consumer.subscribe(Collections.singletonList(inTopic));
        while (true) {
            ConsumerRecords<K, V> consumerRecords = consumer.poll(Duration.ofMillis(100));
            consumerRecords.forEach(t ->
                    _logger.info("#### Consuming from topic : " + t.topic() +
                            "\nPartition : " + t.partition() +
                            "\nOffset : " + t.offset() +
                            "\nKey : " + t.key() +
                            "\nValue : " + t.value() +
                            "\nHeaders : " + t.headers()));
        }
    }
}
