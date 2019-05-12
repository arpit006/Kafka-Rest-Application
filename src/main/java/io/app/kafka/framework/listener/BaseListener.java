package io.app.kafka.framework.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * This is a Kafka Listener which listens to Kafka Topic.
 *
 * @author <a href = "mailto: iarpitsrivastava06@gmail.com"> Arpit Srivastava</a>
 */
@Service
public class BaseListener {

    private static final Logger _logger = LoggerFactory.getLogger(BaseListener.class);

    /**
     * In this case we have made a topic with 3 partitions, Manipulate the @PartitionOffset accordingly.
     *
     * This method is triggered by the api through the service layer.
     * This method consumes data from the given topic.
     *
     * @param inJson The json received to be stored in Kafka topic.
     * @param key Key for Partition
     * @param receivedPartitionId Partition of the topic
     * @param topic topic name
     * @param offset offset of the partition.
     */
    @KafkaListener(/*containerFactory = "kafkaListenerContainerFactory",*/ topicPartitions = {
            @TopicPartition(topic = "business_topic_1", partitionOffsets = {
                    @PartitionOffset(partition = "0", initialOffset = "0"),
                    @PartitionOffset(partition = "1", initialOffset = "0"),
                    @PartitionOffset(partition = "2", initialOffset = "0")
            })
    })
    public void consume(@Payload String inJson,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) String receivedPartitionId,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                        @Header(KafkaHeaders.OFFSET) String offset) {
        _logger.info("#### LISTENING TO TOPIC : -> " + topic +
                "\nOffset : " + offset +
                "\nKey : " + key +
                "\nJSON : " + inJson +
                "\nPartition Id : " + receivedPartitionId);
    }
}
