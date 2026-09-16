/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapppart1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * The LoginTest class contains Junit tests used to test
 * the methods in the Login class.
 * 
 * Each test checks whether a method produces the
 * expected results.
 * @author Student
 */
public class LoginTest {
    
  /**
   * Test of checkUserName() method, of class Login.
   * 
   * This test uses a valid username, which contains
   * an underscore and is no more than five characters long.
   * 
   * assertTrue() checks that the method returns true.
   */
    @Test
    public void TestValidUsername(){
        //Create a Login object with Valid registration information.
        Login login = new Login(
        "Kyle",
        "Makhohliso",
        "kyl_l",
        "Ch&&sec@ke99!",
        "+27838968976");
        
        //Check that the username validation returns true.
        assertTrue(login.checkUserName());
    }
    
    /**
     * Test of checkPasswordComplexity() method, of class Login.
     * 
     * This test checks whether a password containing the required
     * uppercase letter, number and special character is accepted.
     */
        
        @Test
        public void TestValidPasswordComplexity(){
            Login login = new Login ( 
              "Kyle",
        "Makhohliso",
        "kyl_l",
        "Ch&&sec@ke99!",
        "+27838968976");
            /*
            check that the password complexity method returns true.
            *
            */
        assertTrue (login.checkPasswordComplexity());
        }
        
        @Test
    public void TestValidPhoneNummber(){
        Login login = new Login(
        "Kyle",
        "Makhohliso",
        "kyl_l",
        "Ch&&sec@ke99!",
        "+27838968976");
        assertTrue(login.checkCellphoneNumber());
    }
    
    @Test
    public void testRegisterUser() {
        Login login = new Login ( 
         "Kyle",
        "Makhohliso",
        "kyl_l",
        "Ch&&sec@ke99!",
        "+27838968976");
        
        String result = login.registerUser();
        
        
        
        
        assertEquals("""
                    Username successfully captured.
                     Password successfully captured.
                     Cell phone number seccessfuly added.
                     """,
                result);
                
    }

}

@Test
public void testLoginUser(){
    Login login = new Login(
    "Kyle",
        "Makhohliso",
            "kyl_l",
        "Ch&&sec@ke99!",
        "+27838968976");
    //Store the username entered during login.
    login.setEnteredUsername("kyl_l");
            
}