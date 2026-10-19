
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 * to edit this template
 */
package com.mycompany.chatapppart1;

import java.util.Scanner;

/**
 * The Main class runs the ChatApp application.
 * It accepts keyboard input from the user and controls
 * the registration and login process.
 *
 * @author Student
 */
public class Main {

    /*
     * The main method is the starting point of the application.
     */
    public static void main(String[] args) {

        // Create a Scanner object to accept keyboard input from the user.
        Scanner input = new Scanner(System.in);

        // Display the registration heading.
        System.out.println("=====REGISTRATION=====");

        // Ask the user to enter their first name.
        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        // This ensures that the user cannot continue without entering their first name.
        while (firstName.trim().isEmpty()) {
            System.out.println("First name cannot be empty.");
            System.out.print("Enter your first name: ");
            firstName = input.nextLine();
        }

        // Ask the user to enter their last name.
        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        // This ensures that the user cannot continue without entering their last name.
        while (lastName.trim().isEmpty()) {
            System.out.println("Last name cannot be empty.");
            System.out.print("Enter your last name: ");
            lastName = input.nextLine();
        }

        // Ask the user to enter their username.
        System.out.print("Enter your username: ");
        String username = input.nextLine();

        // This ensures that the user cannot continue without entering their username.
        while (username.trim().isEmpty()) {
            System.out.println("Username cannot be empty.");
            System.out.print("Enter your username: ");
            username = input.nextLine();
        }

        /*
         * Create a Login object using the information captured so far.
         * The password and cellphone number are temporarily empty because
         * they have not been entered yet.
         */
        Login login = new Login(
                firstName,
                lastName,
                username,
                "",
                ""
        );

        // Check the username before continuing to the password.
        if (!login.checkUserName()) {
            System.out.println(
                    "Username is not correctly formatted; please ensure that your username "
                    + "contains an underscore and is no more than five characters in length."
            );
            return;
        }

        // Displays this message if username is valid.
        System.out.println("Username successfully captured.");

        // Ask the user to enter their password.
        System.out.print("Enter your password: ");
        String password = input.nextLine();

        while (password.trim().isEmpty()) {
            System.out.println("Password cannot be empty.");
            System.out.print("Enter your password: ");
            password = input.nextLine();
        }

        // Store the password in the Login object.
        login.setPassword(password);

        // Check the password before continuing to the cellphone number.
        if (!login.checkPasswordComplexity()) {
            System.out.println(
                    "Password is not correctly formatted; please ensure that the password "
                    + "contains at least eight characters, a capital letter, a number, "
                    + "and a special character."
            );
            return;
        }

        // Displays this message if password is valid.
        System.out.println("Password successfully captured.");

        // Ask the user to enter their cellphone number.
        System.out.print("Enter your cellphone number: ");
        String phoneNumber = input.nextLine();

        while (phoneNumber.trim().isEmpty()) {
            System.out.println("Cellphone number cannot be empty.");
            System.out.print("Enter your cellphone number: ");
            phoneNumber = input.nextLine();
        }

        // Store the cellphone number in the Login object.
        login.setPhoneNumber(phoneNumber);

        // Check the cellphone number before continuing to login.
        if (!login.checkCellPhoneNumber()) {
            System.out.println(
                    "Cellphone number is not correctly formatted; please ensure that the "
                    + "cellphone number starts with +27 and is followed by 9 numbers."
            );
            return;
        }

        // Displays this message if cellphone number is valid.
        System.out.println("Cellphone number successfully added.");

        // Display the login heading.
        System.out.println();
        System.out.println("=====LOGIN=====");

        // Ask the user to enter their username.
        System.out.print("Enter your username: ");
        String enteredUsername = input.nextLine();

        while (enteredUsername.trim().isEmpty()) {
            System.out.println("Username cannot be empty.");
            System.out.print("Enter your username: ");
            enteredUsername = input.nextLine();
        }

        // Check whether the entered username matches the registered username.
        if (!enteredUsername.equals(login.getUsername())) {
            System.out.println("Username or password incorrect, please try again.");
            return;
        }

        // Ask the user to enter their password.
        System.out.print("Enter your password: ");
        String enteredPassword = input.nextLine();

        while (enteredPassword.trim().isEmpty()) {
            System.out.println("Password cannot be empty.");
            System.out.print("Enter your password: ");
            enteredPassword = input.nextLine();
        }

        // Store the username and password entered during login.
        login.setEnteredUsername(enteredUsername);
        login.setEnteredPassword(enteredPassword);

        // Check whether the login credentials are correct.
        if (!login.loginUser()) {
            System.out.println(login.returnLoginStatus());
            return;
        }

        // Display the successful login message.
        System.out.println(login.returnLoginStatus());
        System.out.println("Welcome to QuickChat.");

        // Ask how many messages the user wants to enter.
        System.out.print("How many messages would you like to send? ");

        int messageLimit;

        while (true) {
            String numberInput = input.nextLine();

            try {
                messageLimit = Integer.parseInt(numberInput);

                if (messageLimit >= 1) {
                    break;
                }

                System.out.print("Please enter at least 1 message: ");

            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a whole number: ");
            }
        }

        // Track how many messages have been processed.
        int messagesEntered = 0;
        Message lastMessage = null;

        // Display the QuickChat menu until the user chooses to quit.
        while (true) {

            System.out.println();
            System.out.println("===== QUICKCHAT MENU =====");
            System.out.println("1) Send messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose an option: ");

            String menuChoice = input.nextLine();

            switch (menuChoice) {

                case "1" -> {
                    // Check whether the message limit has been reached.
                    if (messagesEntered >= messageLimit) {
                        System.out.println(
                                "You have reached your message limit."
                        );
                        break;
                    }

                    // Ask for the recipient's cellphone number.
                    System.out.print("Enter recipient cellphone number: ");
                    String recipient = input.nextLine();

                    // Create a temporary object only for validation.
                    // NOTE: We will improve this when we finish Message.java.
                    Message recipientCheck =
                            new Message("0000000000", recipient, "Validation", 0);

                    String recipientStatus =
                            recipientCheck.checkRecipientCell();

                    if (!recipientStatus.equals(
                            "Cell phone number successfully captured.")) {
                        System.out.println(recipientStatus);
                        break;
                    }

                    // Ask for the message text.
                    System.out.print("Enter your message: ");
                    String messageText = input.nextLine();

                    // Check that the message is not empty or too long.
                    if (messageText.trim().isEmpty()) {
                        System.out.println("Message cannot be empty.");
                        break;
                    }

                    if (messageText.length() > 250) {
                        System.out.println(
                                "Message exceeds 250 characters by "
                                        + (messageText.length() - 250)
                                        + "; please reduce the size."
                        );
                        break;
                    }

                    // Create the message object.
                    Message message = new Message(
                            recipient, messageText
                    );

                    // Generate and display the message hash.
                    System.out.println(
                            "Message Hash: " + message.createMessageHash()
                    );

                    // Ask the user what to do with the message.
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message");
                    System.out.print("Choose an option: ");

                    String actionChoice = input.nextLine();

                    // Process the selected action.
                    String actionResult =
                            message.sentMessage(actionChoice);

                    System.out.println(actionResult);

                    // If the user chooses to disregard the message,
                    // ask them to confirm deletion by entering 0.
                    if (actionChoice.equals("2")) {
                        System.out.print("Enter 0 to delete the message: ");
                        String deleteChoice = input.nextLine();

                        if (deleteChoice.equals("0")) {
                            System.out.println("Message deleted.");
                        } else {
                            System.out.println(
                                    "Invalid input. Message was not deleted."
                            );
                        }
                    }

                    // Display message details only when it is sent.
                    if (actionChoice.equals("1")
                            && actionResult.equals(
                                    "Message successfully sent.")) {

                        System.out.println(
                                "Message ID: " + message.getMessageID()
                        );

                        System.out.println(
                                "Recipient: " + recipient
                        );

                        System.out.println(
                                "Message: " + messageText
                        );
                    }

                    // Save the message as the most recently processed message.
                    lastMessage = message;

                    // Increase the count only after a valid action is selected.
                    if (actionChoice.equals("1")
                            || actionChoice.equals("2")
                            || actionChoice.equals("3")) {
                        messagesEntered++;
                    }
                }

                case "2" -> {
                    // Display the messages that have been successfully sent.
                    if (lastMessage == null) {
                        System.out.println("No messages have been sent yet.");
                    } else {
                        System.out.println(
                                "===== RECENTLY SENT MESSAGES ====="
                        );
                        System.out.println(lastMessage.printMessages());
                    }
                }

                case "3" -> {
                    // Exit the QuickChat menu.
                    System.out.println("Exiting QuickChat.");

                    if (lastMessage != null) {
                        System.out.println(
                                "Total messages sent: "
                                        + lastMessage.returnTotalMessages()
                        );
                    } else {
                        System.out.println("Total messages sent: 0");
                    }

                    input.close();
                    return;
                }

                default -> System.out.println(
                            "Invalid option. Please choose 1, 2, or 3."
                    );
            }
        }
    }
}
