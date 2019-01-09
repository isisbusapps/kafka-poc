package com.cloudurable.kafka.examples.UserExample;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerUserExample {

    private final static String TOPIC ="my-example-topic";
    private final static String BOOTSTRAP_SERVERS = "localhost:9092,localhost:9093,localhost:9094";

    private static Producer<String, User> createProducer() {

        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "kafkaExampleProducer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"com.cloudurable.kafka.examples.UserExample.UserSerializer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        return new KafkaProducer<>(props);
    }



    public static void runProducerUser(final int sendMessageCount) throws InterruptedException {
        final Producer<String, User> producer = createProducer();
        User user = new User("Ffion Argent", 26, "STFC");
        long time = System.currentTimeMillis();

        try{
            for (long index = time; index < time + sendMessageCount; index++){
                final ProducerRecord<String, User> record = new ProducerRecord<String, User>(TOPIC, user);

                RecordMetadata metadata= producer.send(record).get();

                long elapsedTime = System.currentTimeMillis() - time;
                System.out.println("Message " + record.value() + " sent !!");
                System.out.println("Partition: " + metadata.partition());
                System.out.println("Offset: " + metadata.offset());
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.flush();
            producer.close();
        }
    }

    public static void main(String...args) throws Exception {
        runProducerUser(5);
    }
}
