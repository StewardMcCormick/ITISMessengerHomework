package com.mccormick.message;

import com.mccormick.User.User;

import java.util.ArrayList;
import java.util.List;

public class MessagesDatabase {
    private List<Message> messageList = new ArrayList<>();

    public void addNewMessage(Message message) {
        messageList.add(message);
    }

    public List<Message> getAllMessages() {
        return messageList;
    }

    public List<Message> getMessagesBySender(User user) {
        List<Message> resultList = new ArrayList<>();

        for (Message m : messageList) {
            if (m.getSender().getUserName().equals(user.getUserName())) {
                resultList.add(m);
            }
        }

        return resultList;
    }

    public List<Message> getMessagesByReceiver(User user) {
        List<Message> resultList = new ArrayList<>();

        for (Message m : messageList) {
            if (m.getReceiver().getUserName().equals(user.getUserName())) {
                resultList.add(m);
            }
        }

        return resultList;
    }
}
