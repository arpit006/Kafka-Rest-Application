package io.app.kafka.framework.producer;

import io.app.kafka.framework.parser.JsonParser;
import io.app.kafka.framework.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Map;

/**
 * Producer which will be called to post values into the Kafka Topic
 *
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
public class BaseProducer<K, V> {

    private static final Logger _logger = LoggerFactory.getLogger(BaseProducer.class);
    private final String inTopic;
    private KafkaTemplate<K, V> kafkaTemplate;

    public BaseProducer(KafkaTemplate<K, V> kafkaTemplate, String inTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.inTopic = inTopic;
    }

    /**
     * `
     * This method will post value to Kafka Topic
     *
     * @param inJson The value to be posted into the topic
     */
    public V postMessageToTopic(V inJson) {
        // Parse the json.
        Map<String, Object> t = JsonParser.parseJson(String.valueOf(inJson));
        K key = (K) t.get("key");

        _logger.info("#### Producing Message : " + inJson + "\nTopic : " + inTopic);

        // Using Kafka Producer with the Rest Template, by specifying the Topic, Key and value to be posted.
        ListenableFuture<SendResult<K, V>> future = kafkaTemplate.send(inTopic, key, inJson);

        // This send method is asynchronous hence we can listen to the topic on success or failure.
        // This Kafka producer method sends acknowledgement once the data is successfully received by the Kafka Topic
        future.addCallback(new ListenableFutureCallback<SendResult<K, V>>() {
            @Override
            public void onFailure(Throwable ex) {
                _logger.error("#### Kafka Producer Error :: -> " + ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<K, V> result) {
                _logger.info("#### Message sent to Topic :: -> " +
                        "\nProducer Record : -> " + result.getProducerRecord().toString() +
                        "\nRecord : -> " + result.getRecordMetadata() +
                        "\nTopic : -> " + result.getRecordMetadata().topic() +
                        "\nPartition : -> " + result.getRecordMetadata().offset() +
                        "\nOffset : -> " + result.getRecordMetadata().offset());
            }
        });
        return (V) JsonUtil.toJson("{Topic:" + inTopic + ",Message: " + inJson + "}");
    }
}
