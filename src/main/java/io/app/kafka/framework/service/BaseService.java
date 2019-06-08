package io.app.kafka.framework.service;

import io.app.kafka.framework.consumer.BaseConsumer;
import io.app.kafka.framework.producer.BaseProducer;

/**
 * This service class connects with the api layer and internally contacts the Kafka methods.
 *
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public class BaseService<K, V> {

    private final
    BaseProducer<K, V> baseProducer;

    private final
    BaseConsumer<K, V> baseConsumer;

    public BaseService(BaseProducer<K, V> baseProducer, BaseConsumer<K, V> baseConsumer) {
        this.baseProducer = baseProducer;
        this.baseConsumer = baseConsumer;
    }

    /**
     * Posts to the topic via Kafka Producer.
     *
     * @param inJson value
     * @return Return Value
     */
    public V postToTopic(V inJson) {
        return baseProducer.postMessageToTopic(inJson);
    }

    /**
     * Consumes from the Topic via Kafka Consumer.
     *
     * @return Return Message.
     */
    public V consumeFromTopic() {
        baseConsumer.consume();
        return (V) "Successfully Consumed Data from Topic";
    }

}
