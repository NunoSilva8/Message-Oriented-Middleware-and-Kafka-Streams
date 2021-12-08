package kafka;

import entities.Credit;
import entities.Currency;
import entities.Payment;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.*;

public class SimpleProducer {
    public static void main(String[] args) throws Exception {

        //Assign topicName to string variable
        //String topicName = args[0].toString();
        //TODO: verificar se basta mudar o nome do Topic como indica no link: https://stackoverflow.com/a/39093686
        String creditsTopic = "credits";
        String paymentsTopic = "payments";

        // create instance for properties to access producer configs
        Properties props = new Properties();

        //Assign localhost id
        props.put("bootstrap.servers", "localhost:9092");

        //Set acknowledgements for producer requests.
        props.put("acks", "all");

        //If the request fails, the producer can automatically retry,
        props.put("retries", 0);

        //Specify buffer size in config
        props.put("batch.size", 16384);

        //Reduce the no of requests less than 0
        props.put("linger.ms", 1);

        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        Boolean keepOnGoing = true;
        Long amount;
        List<Currency> currencies = new ArrayList<>();
        Currency selectedCurrency;
        Random rand;
        List<String> typeOfOperation = new ArrayList<>(List.of("Credit", "Payment"));
        String key;

        do{
            amount = (long)(Math.random() * 10000L);
            rand = new Random();
            selectedCurrency = currencies.get(rand.nextInt(currencies.size()));
            key = typeOfOperation.get(rand.nextInt(typeOfOperation.size()));

            if(key.equals("Credit")){
                producer.send(new ProducerRecord<String, String>(creditsTopic, key, new Credit( null, selectedCurrency, amount).toString()));
                System.out.println("Sending message to topic " + creditsTopic);
            }
            else{
                producer.send(new ProducerRecord<String, String>(paymentsTopic, key, new Payment(selectedCurrency, amount ).toString()));
                System.out.println("Sending message to topic " + paymentsTopic);
            }
        }while(keepOnGoing);


        producer.close();
    }
}