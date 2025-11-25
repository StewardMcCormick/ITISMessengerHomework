package com.mccormick.groupe;

import com.mccormick.User.User;
import com.mccormick.message.Message;

import java.util.List;

public class Groupe {

	private String name;

	private User owner;

	private List<Message> messageList;

	public Groupe(String name, User owner, List<Message> messageList) {
		this.name = name;
		this.owner = owner;
		this.messageList = messageList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
}
