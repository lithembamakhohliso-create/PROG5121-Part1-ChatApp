/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java
 * to edit this template
 */
package com.mycompany.chatapppart1;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Message class handles message details,
 * validation
 *
 * @author Student
 */
public class Message {

    // Variables used to store message information
    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;

    // Stores the total number of successfully sent messages
    private static int totalMessages = 0;

    // Stores messages successfully sent during the current session
    private static List<Message> sentMessages = new ArrayList<>();

    // Stores the number assigned to this message, starting at 0
    private int messageNumber;

    // Automatically assigned to this message, starting at 0
    private static int nextMessageNumber = 0;

    public String getMessageID() {
        return messageID;
    }

    // Creates a message with an automatically generated ID
    public Message(String recipient, String message) {
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.message = message;
        this.messageNumber = nextMessageNumber++;
    }

    // Creates a message with a supplied ID for unit testing
    public Message(String messageID, String recipient, String message) {
        this.messageID = messageID;
        this.recipient = recipient;
        this.message = message;
        this.messageNumber = nextMessageNumber++;
    }

    // Creates a message with a specific number for unit testing
    public Message(String messageID, String recipient, String message, int messageNumber) {
        this.messageID = messageID;
        this.recipient = recipient;
        this.message = message;
        this.messageNumber = messageNumber;
    }

    // Generates a random ten-digit message ID
    public String generateMessageID() {
        long randomID = java.util.concurrent.ThreadLocalRandom
                .current()
                .nextLong(1000000000L, 10000000000L);

        return String.valueOf(randomID);
    }

    // Checks that the message ID is no more than ten characters
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }

    // Checks whether the message exceeds 250 characters
    public String checkMessageLength() {
        if (message == null || message.trim().isEmpty()) {
            return "Message cannot be empty.";
        }

        if (message.length() > 250) {
            int excessCharacters = message.length() - 250;

            return "Message exceeds 250 characters by "
                    + excessCharacters
                    + "; please reduce the size.";
        }

        return "Message sent";
    }

    // Checks the recipient number's format
    public String checkRecipientCell() {
        if (recipient != null
                && recipient.matches("\\+27[0-9]{9}")) {
            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted "
                + "or does not contain an international code. "
                + "Please correct the number and try again.";
    }

    // Creates a hash using the ID, message number, first word and last word
    public String createMessageHash() {
        if (messageID == null || messageID.length() < 2
                || message == null || message.trim().isEmpty()) {
            return "";
        }

        // Get the first two digits of the message ID
        String firstTwoDigits = messageID.substring(0, 2);

        // Remove punctuation and split the message into words
        String cleanedMessage = message.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = cleanedMessage.trim().split("\\s+");

        // Get the first and last words
        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        // Build the hash and convert it to uppercase
        messageHash = (firstTwoDigits + ":"
                + messageNumber + ":"
                + firstWord + lastWord).toUpperCase();

        return messageHash;
    }

    // Allows the user to send, disregard or store a message
    public String sentMessage(String choice) {
        switch (choice) {
            case "1":
                sentMessages.add(this);
                totalMessages++;
                return "Message successfully sent.";

            case "2":
                return "Press 0 to delete the message.";

            case "3":
                return storeMessage();

            default:
                return "Invalid choice. Please select 1, 2, or 3.";
        }
    }

    // Displays the messages successfully sent during this session.
    public String printMessages() {
        StringBuilder output = new StringBuilder();

        for (Message sentMessage : sentMessages) {
            output.append("Message ID: ")
                    .append(sentMessage.messageID)
                    .append("\nMessage Hash: ")
                    .append(sentMessage.messageHash)
                    .append("\nRecipient: ")
                    .append(sentMessage.recipient)
                    .append("\nMessage: ")
                    .append(sentMessage.message)
                    .append("\n");
        }

        if (output.length() == 0) {
            return "No messages have been sent yet.";
        }

        return output.toString();
    }

    // Returns the total number of messages sent
    public int returnTotalMessages() {
        return totalMessages;
    }

    // Stores this message in a JSON file.
    public String storeMessage() {
        String fileName = "messages.json";
        List<String> jsonMessages = new ArrayList<>();

        // Read existing messages from the JSON file.
        java.io.File file = new java.io.File(fileName);

        if (file.exists()) {
            try (java.util.Scanner fileReader =
                    new java.util.Scanner(file)) {

                StringBuilder content = new StringBuilder();

                while (fileReader.hasNextLine()) {
                    content.append(fileReader.nextLine());
                }

                String existing = content.toString().trim();

                if (existing.startsWith("[")
                        && existing.endsWith("]")) {

                    existing = existing.substring(
                            1, existing.length() - 1
                    ).trim();

                    if (!existing.isEmpty()) {
                        // Keep existing JSON objects.
                        jsonMessages.add(existing);
                    }
                }

            } catch (IOException e) {
                return "Unable to read the message storage file.";
            }
        }

        // Escape special characters before adding text to JSON.
        String safeMessage = message
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");

        String safeRecipient = recipient
                .replace("\\", "\\\\")
                .replace("\"", "\\\"");

        String safeHash = createMessageHash()
                .replace("\\", "\\\\")
                .replace("\"", "\\\"");

        // Create a JSON object for the current message.
        String newObject = "{"
                + "\"messageID\":\"" + messageID + "\","
                + "\"messageHash\":\"" + safeHash + "\","
                + "\"recipient\":\"" + safeRecipient + "\","
                + "\"message\":\"" + safeMessage + "\""
                + "}";

        // Add the current message and write the JSON array.
        jsonMessages.add(newObject);

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("[\n");

            for (int i = 0; i < jsonMessages.size(); i++) {
                writer.write(jsonMessages.get(i));

                if (i < jsonMessages.size() - 1) {
                    writer.write(",");
                }

                writer.write("\n");
            }

            writer.write("]");

            return "Message successfully stored.";

        } catch (IOException e) {
            return "Unable to store the message.";
        }
    }
}
