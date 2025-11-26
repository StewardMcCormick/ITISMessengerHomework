package com.mccormick.chat;

import com.mccormick.User.User;

public class PrivateChat extends Chat {

	public PrivateChat(String name) {
		super(name);
	}

	public PrivateChat(User user1, User user2) {
		super();
		this.members.add(user1);
		this.members.add(user2);
	}
}
