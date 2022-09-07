package com.nt.runner;

import java.util.Date;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
@Component
public class PTPMessageSenderRunner implements CommandLineRunner {
	@Autowired
	private JmsTemplate template;
	@Override
	public void run(String... args) throws Exception {
	/*	//Normal Anonymous Inner Class for MessageCreator()
		template.send("queue1",new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				Message message=session.createTextMessage("From Sender "+new Date());
				return message;
			}
		}); */
		
		
		/*//LAMBDA Based Anonymous Inner Class for MessageCreator()
		template.send("queue1",ses->{
			Message message=ses.createTextMessage("From Sender :: "+new Date());
			return message;
		}); */
		
		//LAMBDA Based Anonymous Inner Class for MessageCreator()
				template.send("queue1",ses->ses.createTextMessage("From Sender :: "+new Date()));
		System.out.println("From Sender ---->  Msg is Sent ");
	}

}
