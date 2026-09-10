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
   
    //Declere variables that are going to be used by the user
    String username;
    String password;
    String phoneNumber;
    String firstName;
    String lastName;
    /*
    *constactor used to initialise the user registation details.
    *The values entered by the userare assigned to the class variable.
    */
   public Login (String firstName, String lastName, String username, String password, String phoneNumber){
       this.firstName = firstName;
       this.lastName = lastName;
       this.username = username;
       this.password = password;
       this.phoneNumber = phoneNumber;
    }
    
   //Username Validation
    public boolean checkUserName (String username) {
        if (username.contains("_")&& username.length()<=5){
            return true;
        }else
            return false;
    }
        
    }
        
        //Password validation
        public boolean checkPasswordComplexity(String password) {
            
            boolean hasCapital = false;
            boolean hasNumber = false;
            boolean hasSpecial = false;
            
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                
                if (Character.isUpperCase(c)) {
                    hasCapital = true;
                } else if (Character.isDigit(c)) {
                    hasNumber = true;
                } else if (!Character.isLetterOrDigit(c)) {
                    hasSpecial = true;
                }
            }
            return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
        }
            //cellphone validation should start with +27
            public boolean checkCellphoneNumber(String phone) {
                return phone.startsWith("+27") && phone.length() <= 12;
            }
                
            //Register Validation
            
            public String registerUser(String username, String password, String phoneNumber){
                
                if (!checkUserName(username)){
                    return "Usename is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
                }
                    
                    
                 if (!checkPasswordComplexity(password)) { 
return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character."; 
} 
if (!checkCellphoneNumber(phoneNumber)) { 
return "Cell phone number incorrectly formatted or does not contain international code."; 
} 

               
               
                    
                    
                    
                }
            }
//Login feature validation
public boolean loginUser(String username, String password) {
  return this.username.equals(username) && this.password.equals(password);
}
            
        
