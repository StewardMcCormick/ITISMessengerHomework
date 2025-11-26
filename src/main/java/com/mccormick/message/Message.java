package com.mccormick.message;

import com.mccormick.User.User;

import java.util.Date;

public class Message {
    private final String text;
    private final Date date;
    private final User sender;
    private final User receiver;

    public Message(String text, User sender, User receiver) {
        this.text = text;
        this.date = new Date();
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String toString() {
        return "[" + sender.getUserName() + " -> " + receiver.getUserName() + " | " + date + "] " + text;
    }
}
