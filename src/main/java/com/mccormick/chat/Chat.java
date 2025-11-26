package com.mccormick.chat;

import com.mccormick.User.User;
import com.mccormick.message.Message;

import java.util.LinkedList;
import java.util.List;

public class Chat {

	private String name;

	protected List<User> members;

	private List<Message> messageList = new LinkedList<>();

	public Chat(User firstUser, String name) {
		this.name = name;
		this.members.add(firstUser);
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
