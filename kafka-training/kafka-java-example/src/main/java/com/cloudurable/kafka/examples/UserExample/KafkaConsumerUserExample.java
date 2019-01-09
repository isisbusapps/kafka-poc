package com.cloudurable.kafka.examples.UserExample;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.LongDeserializer;

import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerUserExample {

    private final static String TOPIC = "my-example-topic";
    private final static String BOOTSTRAP_SERVERS = "localhost:9092,localhost:9093,localhost:9094";

    private static Consumer<String, User> createConsumer(){
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "kafkaExampleConsumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"com.cloudurable.kafka.examples.UserExample.UserDeserializer");


        //Create the consumer using the props object
        final Consumer<String, User> consumer = new KafkaConsumer<String, User>(props);

        //Subscribe to the topic
        consumer.subscribe(Collections.singleton(TOPIC));
        return consumer;
    }


    static void runConsumerUser() throws InterruptedException {
        final Consumer<String, User> consumer = createConsumer();
        final int giveUp = 100;
        int noRecordsCount = 0;

        while(true) {
            final ConsumerRecords<String, User> consumerRecords = consumer.poll(1000);
            if (consumerRecords.count()==0) {
                noRecordsCount++;
                if (noRecordsCount > giveUp) break;
                else continue;
            }

            for (ConsumerRecord<String, User> message : consumerRecords) {
                System.out.println("Message received " + message.value().toString());
            }
        }
    }

    public static void main(String... args) throws Exception {
        runConsumerUser();
    }
}
