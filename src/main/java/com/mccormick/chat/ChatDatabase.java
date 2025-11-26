package com.mccormick.chat;

import java.util.LinkedList;
import java.util.List;

public class ChatDatabase {
	private List<Chat> chatList = new LinkedList<>();

	public Chat getChatListByName(String name) {
		for (Chat e : this.chatList) {
			if (e.getName().equals(name)) {
				return e;
			}
		}

		return null;
	}
}
