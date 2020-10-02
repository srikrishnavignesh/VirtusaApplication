package com.virtusa.neuralhack.bc.model;

import java.util.Date;

public class Message {
	
	
	String userName;
	String content;
	String date;
	public Message(){
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Message [userName=" + userName + ", content=" + content + ", date=" + date + "]";
	}
	
	
	

}
