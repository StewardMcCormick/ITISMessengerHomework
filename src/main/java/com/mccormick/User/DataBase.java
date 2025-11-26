package com.mccormick.User;
//Made by alexkrug
public class DataBase {

    public int amountOfUsers = 1000; // Show how many users can be registered on our platform

    private int newUserCarriage = 3; // This carriage moves dynamically then new user registers
    //Init value == 3, because database already has 3 users

    private User[] arrayOfLogins = new User[amountOfUsers];//Array of Users

    public DataBase() {
        arrayOfLogins[0] = new User("Egor Bessonov", "123");
        arrayOfLogins[1] = new User("Nikita Fomin", "IloveBeer");
        arrayOfLogins[2] = new User("alexkrug", "IloveDM");

    }

    public User getByName(String name) {
        for (int i = 0; i < newUserCarriage; i++) {
            if (arrayOfLogins[i].getUserName().equals(name)) {
                return arrayOfLogins[i];
            }
        }
        return null;
    }

    public User[] getUsers() {
        User[] arrayOfUsers = new User[newUserCarriage];
        for (int i = 0; i < newUserCarriage; i++) {
            arrayOfUsers[i] = arrayOfLogins[i];
        }
        return arrayOfUsers;
    }

    public boolean addNewUser(User user) { // Add new User
        if (newUserCarriage < amountOfUsers) {
            arrayOfLogins[newUserCarriage] = user;
            newUserCarriage += 1;
            return true;
        }else {
            return false;
        }
    }
}
