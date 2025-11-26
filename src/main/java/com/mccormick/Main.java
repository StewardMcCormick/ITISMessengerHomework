package com.mccormick;

import java.util.Scanner;

import com.mccormick.User.DataBase;
import com.mccormick.User.User;
import com.mccormick.message.Message;
import com.mccormick.message.MessagesDatabase;

public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        MessagesDatabase messageDatabase = new MessagesDatabase();
        Scanner scanner = new Scanner(System.in);

        messageDatabase.addNewMessage(new Message("Hi! what's going on?", dataBase.getByName("Nikita Fomin"), dataBase.getByName("alexkrug")));
        messageDatabase.addNewMessage(new Message("Почему ты пишешь на английском? Тут и на русском писать можно", dataBase.getByName("alexkrug"), dataBase.getByName("Nikita Fomin")));
        messageDatabase.addNewMessage(new Message("А что вы без меня общаетесь?", dataBase.getByName("Egor Bessonov"), dataBase.getByName("alexkrug")));
        messageDatabase.addNewMessage(new Message("А ты как об этом узнал?", dataBase.getByName("Nikita Fomin"), dataBase.getByName("Egor Bessonov")));
        // My schizophrenia is progressing, help me

        User activeUser = enterProcess(dataBase, scanner);

        if (activeUser != null) {
            sendMessageHandler(activeUser, scanner, dataBase, messageDatabase);
        }

        printAllMessages(messageDatabase);
    }

    private static User enterProcess(DataBase dataBase, Scanner scanner) {
        while (true) {
            System.out.println("Enter your Username, please (or \"q\" to quit the program)");
            String name = scanner.nextLine();
            if (dataBase.getByName(name) != null) {
                System.out.println("Enter Password, please");
                String password = scanner.nextLine();
                if (password.equals(dataBase.getByName(name).getPassword())) {
                    User user = dataBase.getByName(name);
                    System.out.printf("Welcome, %s!\n", user.getUserName());
                    return user;
                } else {
                    System.out.println("The password is incorrect. Try again");
                }

            } else {
                System.out.println("Oops... You are not registered yet. Do you want to register to our platform?");
                String variant = scanner.nextLine().toLowerCase();
                if (variant.equals("yes")) {
                    System.out.println("Create a password, please");
                    String password = scanner.nextLine();
                    User user = new User(name, password);
                    if (dataBase.addNewUser(user)) {
                        System.out.printf("Welcome, %s!\n", user.getUserName());
                        return user;
                    } else {
                        System.out.println("Data is overwhelmed");
                    }
                } else {
                    return null;
                }
            }
        }
    }

    private static void sendMessageHandler(User sender, Scanner scanner, DataBase userDatabase, MessagesDatabase messagesDatabase) {
        System.out.println("Do you want to send a massage? y/n");

        String answer = scanner.nextLine();
        while (!answer.equals("y")) {
            if (answer.equals("n")) {
                System.out.println("It's sad. Goodbye!");
                return;
            }
            System.out.println("Incorrect input. Enter y or n");
            System.out.println("Do you want to send a massage? y/n");
            answer = scanner.nextLine();
        }

        while (true) {
            System.out.println("Enter receiver's username:");
            String receiverUsername = scanner.nextLine();
            User receiver = userDatabase.getByName(receiverUsername);
            while (receiver == null) {
                System.out.println("There's no user with this username, try again");
                receiverUsername = scanner.nextLine();
                receiver = userDatabase.getByName(receiverUsername);
            }

            System.out.println("Enter text:");
            String text = scanner.nextLine();
            Message message = new Message(text, sender, receiver);
            messagesDatabase.addNewMessage(message);

            System.out.println("Do you want to send another massage? y/n");
            answer = scanner.nextLine();

            while (!answer.equals("y")) {
                if (answer.equals("n")) {
                    System.out.println("Goodbye!");
                    return;
                }
                System.out.println("Incorrect input. Enter y or n");
                System.out.println("Do you want to send another massage? y/n");
                answer = scanner.nextLine();
            }
        }
    }

    private static void printAllMessages(MessagesDatabase messagesDatabase) {
        for (Message message : messagesDatabase.getAllMessages()) {
            System.out.println(message);
        }
    }
}
