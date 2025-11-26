package com.mccormick;

import java.util.Locale;
import java.util.Scanner;
import com.mccormick.User.DataBase;
import com.mccormick.User.User;

public class Main {
    public static void enterProcess(DataBase dataBase, Scanner scanner){
        boolean flag = false;
        while (!flag){
            System.out.println("Enter your UserName, please");
            String name = scanner.nextLine();
            if (dataBase.getByName(name) != null) {
                System.out.println("Enter Password, please");
                String password = scanner.nextLine();
                if (password.equals(dataBase.getByName(name).getPassword())) {
                    User user =  dataBase.getByName(name);
                    System.out.printf("Welcome, %s!", user.getUserName());
                    flag = true;
                }else {
                    System.out.println("The password is incorrect. Try again");
                }

            }else {
                System.out.println("Oops... You are not registered yet. Do you want to register to our platform?");
                String variant = scanner.nextLine().toLowerCase();
                if (variant.equals("yes")) {
                    System.out.println("Create a password, please");
                    String password = scanner.nextLine();
                    User user = new User(name, password);
                    if (dataBase.addNewUser(user)) {
                        System.out.printf("Welcome, %s!", user.getUserName());
                        flag = true;
                    }else{
                        System.out.println("Data is overwhelmed");
                    }
                }else {
                    flag = true;
                }
            }
        }
    }

	public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        Scanner scanner = new Scanner(System.in);
        enterProcess(dataBase, scanner);


	}
}
