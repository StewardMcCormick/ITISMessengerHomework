package com.mccormick.chat;

import com.mccormick.message.Message;

import java.util.LinkedList;
import java.util.List;

public class Chat {

	private String name;

	private List<Message> messageList = new LinkedList<>();

	public Chat() {}

	public Chat(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
}
