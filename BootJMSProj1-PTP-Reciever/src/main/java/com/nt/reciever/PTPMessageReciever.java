package com.nt.reciever;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PTPMessageReciever {

	@JmsListener(destination = "queue1")
	public void featchMessage(String text ) {
		System.out.println("The Recieved Message :: "+text);
	}
}
