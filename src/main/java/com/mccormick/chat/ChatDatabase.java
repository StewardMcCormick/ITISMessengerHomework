package com.mccormick.chat;

import com.mccormick.User.User;

import java.util.LinkedList;
import java.util.List;

public class ChatDatabase {
	private List<Chat> chatList = new LinkedList<>();

	public void addNewChat(Chat chat) {
		this.chatList.add(chat);
	}

	public Chat getChatListByName(String name) {
		for (Chat e : this.chatList) {
			if (e.getName().equals(name)) {
				return e;
			}
		}

		return null;
	}

	public List<Chat> getAllChatByUser(User user) {
		List<Chat> result = new LinkedList<>();

		for (Chat e : this.chatList) {
			for (User m : e.members) {
				if (m.getUserName().equals(user.getUserName())) {
					result.add(e);
				}
			}
		}

		return result;
	}
}
