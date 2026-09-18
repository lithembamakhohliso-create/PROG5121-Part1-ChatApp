# PROG5121 Part1 ChatApp


Student Details
Student Name:Lithemba
Student Surname:Makhohliso
Student Number: ST10492545
Module Name: Programming 1A
Module Code:PROG5121
Assessment: Registration and Login Features


PROJECT OVERVIEW
ChatApp Part 1 is a Java-based application that demonstrates a basic user registration and login system. The project allows a user to enter their personal details, create a username and password, and provide a            South African cellphone number. The application checks whether the information entered follows the required rules before allowing the user to log in. The project also includes Junit tests to check that the registration and login methods work correctly.
FEATURES:
User registration
Username validation
Password complexity validation
South African cellphone number validation
User login
Login status messages
Junit unit tests for valid and invalid inputs
TECHNOLOGIES USED:
Java
Maven
NetBeans
JUnit 5
Java Scanner for user inputs
PROJECT STRUCTURE
The project is organised into the following main files:
Main.java – Contains the main program and handles user input, registration and login.
Login.java – Contains the methods used to validate user details and manage the login process.
LoginTest.java – Contains JUnit tests for checking the Login class methods.
Pom.xml – Contains the Maven project configuration and JUnit dependencies.
ReadME.md – Provides information about the project and explains how to use it
HOW THE APPLICATION WORKS
Registration
The user is asked to enter:
First Name
Last Name
Username
Password
Cellphone number
The application checks that the required information has been entered and that the username, password and cellphone number meet the required conditions.
Username Validation
The username must:
Contain an underscore (_)
Be no longer than 5 characters, e.g. kyl_1
Password Validation
The password must:
Contain at least 8 characters
Have at least one uppercase letter
Have at least one number
Have at least one special character, e.g. Ch&&sec@ke99!
Cellphone Number Validation
The cellphone number must:
Starts with +27
Contain the correct number of digits
Follow the required South African international format, e.g. +27838968976
Login
After successful registration, the user enters their username and password. The application compares the entered details with the registered details. If they match, the user receives a successful login message. If they do not match, an error message is displayed.
JUnit Testing
The project contains a LoginTest.java file that tests the different methods in the Login class.
The tests check:
Valid username
Valid password
Valid cellphone number
Successful registration
Successful login
Login status
Invalid username
Invalid password
Invalid cellphone number
There are 9 JUnit tests in total.
RUNNING THE PROJECT
Running the application
Open the project in NetBeans and run the Main.java file. The application will open in the console and ask the user to enter their registration and login details.
Running the tests
The tests can be run using Maven in NetBeans. The project should show:
Tests run: 9, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
 (when all tests pass successfully).
REQUIREMENTS
To run this project, you need:
Java Development Kit (JDK)
Apache Maven
NetBeans IDE
JUnit 5
