package com.nit.test;

import java.util.Properties;
import java.util.Scanner;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaSenderApp {

	public static void main(String[] args) {
		//Prepare Kafka Properties using java.util.Properties class obj
		Properties props=new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		
		//Create Kafka Producer Obj
		KafkaProducer<String, String> producer=new KafkaProducer<String, String>(props);

//		
//		//Create ProducerRecord Obj having topic name and Msg
//		ProducerRecord<String, String> record=new ProducerRecord<String, String>("nit-tp1","WelCome to Kafka Message");
//		//Send the Msg
//		producer.send(record);
//		//Flush the Msg
//		producer.flush();
//		//Close the Link with Bootstrap Server
//		producer.close();
//		System.out.println("Msg Has been Send.......!");

		ProducerRecord<String, String> record=null;
		String msg=null;
		do {
			System.out.print("Enter Msg To Be Send :: ");
			Scanner sc=new Scanner(System.in);
			msg=sc.nextLine();
		//Create ProducerRecord Obj having topic name and Msg
		record=new ProducerRecord<String, String>("nit-tp1",msg);
		//Send the Msg
		producer.send(record);
		//Flush the Msg
		producer.flush();
		}while(!msg.equalsIgnoreCase("stop"));
		//Close the Link with Bootstrap Server
		producer.close();
		System.out.println("App is in Ofline Mode now...");
	
	}
	

}
