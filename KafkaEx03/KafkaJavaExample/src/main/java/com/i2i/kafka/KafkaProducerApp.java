package com.i2i.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import com.google.gson.Gson;

import java.util.Properties;

public class KafkaProducerApp {
    public static void main(String[] args) {
        String topic = "students";
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        try (Producer<String, String> producer = new KafkaProducer<>(props)) {

            Student student = new Student(1, "Koray Erat");
            Gson gson = new Gson();
            String jsonStudent = gson.toJson(student);

            ProducerRecord<String, String> record = new ProducerRecord<>(topic, jsonStudent);

            producer.send(record, (metadata, exception) -> {
                if (exception == null) {
                    System.out.println("Mesaj gönderildi: " + jsonStudent);
                } else {
                    exception.printStackTrace();
                }
            });

        }
    }
}
