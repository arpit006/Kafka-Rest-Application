package io.app.kafka.framework.service;

import io.app.kafka.framework.consumer.BaseConsumer;
import io.app.kafka.framework.producer.BaseProducer;

/**
 * This service class connects with the api layer and internally contacts the Kafka methods.
 *
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public class BaseService<T> {

    private final
    BaseProducer<T> baseProducer;

    private final
    BaseConsumer<T> baseConsumer;

    public BaseService(BaseProducer<T> baseProducer, BaseConsumer<T> baseConsumer) {
        this.baseProducer = baseProducer;
        this.baseConsumer = baseConsumer;
    }

    /**
     * Posts to the topic via Kafka Producer.
     *
     * @param inJson value
     * @return Return Value
     */
    public T postToTopic(T inJson) {
        return baseProducer.postMessageToTopic(inJson);
    }

    /**
     * Consumes from the Topic via Kafka Consumer.
     * @return Return Message.
     */
    public T consumeFromTopic() {
        baseConsumer.consume();
        return (T) "Successfully Consumed Data from Topic";
    }

}
