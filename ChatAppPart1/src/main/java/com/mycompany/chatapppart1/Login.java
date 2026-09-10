/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppart1;

/**
 *
 * @author Student
 */
public class Login {

    // Declare variables that are going to be used by the user
    String username;
    String password;
    String phoneNumber;
    String firstName;
    String lastName;
    String enteredUsername;
    String enteredPassword;

    /*
     * Constructor used to initialise the user registration details.
     * The values entered by the user are assigned to the class variables.
     */
    public Login(String firstName, String lastName, String username,
                 String password, String phoneNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    // Username Validation
    public boolean checkUserName() {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        } else {
            return false;
        }
    }

    // Password Validation
    public boolean checkPasswordComplexity() {

        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        // Password must be at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        for (int i = 0; i < password.length(); i++) {

            char character = password.charAt(i);

            if (Character.isUpperCase(character)) {
                hasUpperCase = true;

            } else if (Character.isDigit(character)) {
                hasNumber = true;

            } else if (!Character.isLetterOrDigit(character)) {
                hasSpecialCharacter = true;
            }
        }

        return hasUpperCase && hasNumber && hasSpecialCharacter;
    }

    // Cellphone validation
    // Number must start with +27 and contain 12 characters
    public boolean checkCellphoneNumber() {

        if (phoneNumber.startsWith("+27") 
                &&
                phoneNumber.length() == 12) {
            
        

        for (int i = 3; i < phoneNumber.length(); i++) {

            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }else{
    return false;
}
    }
    public String registerUser(){
        String message = "";
        if (checkUserName()){
            message += "UserName successfully captured.\n";
        }else{
            message+= "Username is correctly formatted; please ensure that your usename contain an underscore and is no more than five characters.";
        }
        if(checkPasswordComplexity()){
            message+= "Password successfully captured.\n";
        }else{
            message+= "Password is not correctly formated; please ensure that your password contains atleast 8 characters, a capital letter,a special character, and a number";
            
            
        }
        if (checkCellphoneNumber()){
            message+= "Cell phone number successfully added.\n";
        }else{
            message+= "Cell phone number is not correctly formated or does not contain the international code: +27";
        }
        return message;
        
        }
   public boolean loginUser() {
    if (enteredUsername.equals(username)
            && enteredPassword.equals(password)) {
        return true;
    } else {
        return false;
    }
}

public String returnLoginStatus() {
    if (loginUser()) {
        return "Welcome " + firstName + " " + lastName
                + ", it is great to see you again";
    } else {
        return "Username or Password is incorrect, please try again.";
    }
}
}


