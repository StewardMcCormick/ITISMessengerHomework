package com.mccormick.chat;

import com.mccormick.User.User;

public class PrivateChat extends Chat {

	public PrivateChat(User user1, User user2, String name) {
		super(user1, name);
		this.members.add(user2);
	}
}
