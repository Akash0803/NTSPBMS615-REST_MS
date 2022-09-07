package com.nt.runner;

import java.time.LocalDateTime;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.nt.model.Player;
@Component
public class PTPMessageSenderRunner  {
	@Autowired
	private JmsTemplate template;
	@Scheduled(cron = "*/10 * * * * *")
	public void sendMessage() {

		Player player=new Player(101,"Dhoni",LocalDateTime.of(1982,7,2,10,22), "Cricket");
		//LAMBDA Based Anonymous Inner Class for MessageCreator()
				template.convertAndSend("queue2",player);
		System.out.println("From Sender ---->  Msg is Sent ");
	}

}
