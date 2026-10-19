# PROG5121 Part1 ChatApp


Student Details
Student Name:Lithemba
Student Surname:Makhohliso
Student Number: ST10492545
Module Name: Programming 1A
Module Code:PROG5121
Assessment: Registration and Login Features


Assessment: Part 1 part 2
Project Overview
This Java console application was created for PROG5121 Part 1. It lets a user register with a username, password, and South African cellphone number, then log in with those credentials.u for creating, sending, storing, and viewing messages.
Features
Validates usernames for an underscore and a maximum length of five characters
Checks password complexity requirements
Validates South African cellphone numbers in international format (`+27` followed by nine digits)
Registers users and authenticates login credentials
Displays a welcome message using the user's first and last name
Creates message IDs and message hashes
Lets users send, disregard, store, and view messages
Saves stored messages to `messages.json`
Includes JUnit tests for login and message features
Technologies Used
Java 25
Apache Maven
NetBeans
JUnit 5
GitHub
Project Structure
The Maven project is in the `ChatAppPart1` folder.
`src/main/java/com/mycompany/chatapppart1/Main.java` - Runs the console application and handles user input.
`src/main/java/com/mycompany/chatapppart1/Login.java` - Handles registration, validation, and login logic.
`src/main/java/com/mycompany/chatapppart1/Message.java` - Handles message validation, IDs, hashes, sending, and storage.
`src/test/java/com/mycompany/chatapppart1/LoginTest.java` - Tests registration and login features.
`src/test/java/com/mycompany/chatapppart1/MessageTest.java` - Tests message features.
`pom.xml` - Maven project configuration and dependencies.
`messages.json` - Message storage file used by the application.
How to Run
Open the `ChatAppPart1` folder as a Maven project in NetBeans.
Make sure Java 25 is configured for the project.
Run `Main.java` from the `com.mycompany.chatapppart1` package.
Follow the registration and login prompts in the console.
Testing
JUnit tests are located in `LoginTest.java` and `MessageTest.java`. They cover valid and invalid usernames, passwords, cellphone numbers, login results, message length, message IDs, hashes, and message actions.
To run the tests with Maven, open a terminal in the `ChatAppPart1` folder and run:
Regex Reference
The `Message` class checks cellphone numbers using this Java regular expression:
It matches `+27` followed by exactly nine digits. This represents the international format where the leading `0` from a South African national cellphone number is omitted.
The `Login` class performs the equivalent check by verifying that the number begins with `+27`, has 12 characters in total, and contains only digits after the prefix.

