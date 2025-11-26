package com.mccormick.chat;

import com.mccormick.User.User;

public class PrivateChat extends Chat {

	private User[] members = new User[2];

	public PrivateChat(String name) {
		super(name);
	}

	public PrivateChat(User user1, User user2) {
		super();
		this.members[0] = user1;
		this.members[1] = user2;
	}


	public User[] getMembers() {
		return members;
	}

	public void setMembers(User[] members) {
		this.members = members;
	}
}
