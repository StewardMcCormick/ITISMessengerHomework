package com.mccormick.chat;

import com.mccormick.User.User;

import java.util.List;

public class GroupChat extends Chat {

	private List<User> members;

	private User owner;

	public GroupChat(String name, User owner) {
		super(name);
		this.owner = owner;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
}
