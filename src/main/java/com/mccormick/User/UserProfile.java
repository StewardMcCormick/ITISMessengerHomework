package com.mccormick.User;

// Made by alexkrug
public class UserProfile {
    public String UserName;
    public String Password;

    private int UserAge;
    private String Gender;
    private String City;

    public UserProfile(String UserName, String Password){ //Constructor
        this.UserName = UserName;
        this.Password = Password;
    }

    public void SetUserAge(int UserAge){
        this.UserAge = UserAge;
    }

    public void SetGender(String Gender){
        this.Gender = Gender;
    }

    public void SetCity(String City){
        this.City = City;
    }





}
