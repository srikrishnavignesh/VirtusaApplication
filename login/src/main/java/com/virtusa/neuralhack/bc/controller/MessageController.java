package com.virtusa.neuralhack.bc.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.virtusa.neuralhack.bc.model.Message;

@Controller
public class MessageController {
	
	
	
	@MessageMapping("/physicsChat")
	@SendTo("/topic/physics")
	public Message getMessage(Message msg) {
		Date now=new Date();
		msg.setDate(new SimpleDateFormat("dd-MM-YY HH:mm:ss").format(now)); //stamp current date and time to the msg
		return msg;
		
	}

}
