package com.mccormick.User;
//Made by alexkrug
public class DataBase {

    UserProfile user;

    public DataBase(UserProfile user){
        this.user = user;
        ArrayOfLogins[0] = new UserProfile("Egor Bessonov", "123");
        ArrayOfLogins[1] = new UserProfile("Nikita Fomin", "IloveBeer");
        ArrayOfLogins[2] = new UserProfile("alexkrug", "IloveDM");

    }
    public int AmountOfUsers = 1000; // Show how many users can be registered on our platform

    private int NewUserCarriage = 3; // This carriage moves dynamically then new user registers
    //Init value == 3, because database already has 3 users


    private UserProfile[] ArrayOfLogins = new UserProfile[AmountOfUsers];//Array of Users


    public void AddNewUser(){ // Add new User
        ArrayOfLogins[NewUserCarriage] = user;
        NewUserCarriage += 1;
    }

    public int ShowCarriage(){ //Show how many Users have already registered
        return NewUserCarriage;
    }

    public String IsUserInDataBase(){ //Search User in Database
        String IsValidLogin = "I";               // There are two statements (I - Invalid, V - valid)
        String IsValidPassword = "I";
        for (int i = 0; i < NewUserCarriage; i++) {
            if (ArrayOfLogins[i].UserName.equals(user.UserName)){
                IsValidLogin = "V";
                if (ArrayOfLogins[i].Password.equals(user.Password)){
                    IsValidPassword = "V";
                }
                break;

            }
        }


        if (IsValidLogin.equals("I")){
            return "UDE"; //(User don`t exist. It means, that new user is not registered)

        }

        if (IsValidLogin.equals("V") & IsValidPassword.equals("I")){
            return "UE"; //(User exist, but password is incorrect)

        }
        return "UCPC"; //User is in database
    }

}
