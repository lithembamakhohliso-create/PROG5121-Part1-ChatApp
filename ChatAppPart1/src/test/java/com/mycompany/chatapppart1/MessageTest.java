

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java
 * to edit this template
 */
package com.mycompany.chatapppart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testMessageIDGenerated() {

        // Create a message using automatic ID generation.
        Message message = new Message(
                "+271234567", "Hi Mike, join us tonight?"
        );

        // Check that the message ID contains exactly ten digits.
        assertTrue(message.checkMessageID());
        assertTrue(message.getMessageID().matches("\\d{10}"));
    }

    @Test
    public void testMessageLengthWithinLimit() {

        // Create a message with fewer than 250 characters.
        Message message = new Message(
                "0012345678",
                "+271234567",
                "Hi Mike, ca you join us for dinner tonight?",
                0
        );

        // Check the expected success response.
        assertEquals("Message sent", message.checkMessageLength());
    }

    @Test
    public void testMessageLengthExceedsLimit() {

        // Create a message containing 260 characters.
        String longMessage = "A".repeat(260);

        Message message = new Message(
                "0012345678",
                "+271234567",
                longMessage,
                0
        );

        // Check the exact error message.
        assertEquals(
                "Message exceeds 250 characters by 10; please reduce the size.",
                message.checkMessageLength()
        );
    }

    @Test
    public void testValidRecipientCell() {

        // Use a valid South African number in international format.
        Message message = new Message(
                "0012345678",
                "+27123456789",
                "Hello",
                0
        );

        assertEquals(
                "Cell phone number successfully captured.",
                message.checkRecipientCell()
        );
    }

    @Test
    public void testInvalidRecipientCell() {

        // Use a number in local format without the international code.
        Message message = new Message(
                "0012345678",
                "085575975889",
                "Hello",
                0
        );

        assertEquals(
                "Cell phone number is incorrectly formatted "
                + "or does not contain an international code. "
                + "Please correct the number and try again.",
                message.checkRecipientCell()
        );
    }

    @Test
    public void testMessageHash() {

        // Use a fixed ID and message number to test the exact hash.
        Message message = new Message(
                "0012345678",
                "+271234567",
                "Hi Mike, can you join us for dinner tonight?",
                0
        );

        assertEquals(
                "00:0:HITONIGHT",
                message.createMessageHash()
        );
    }

    @Test
    public void testRemainingMessageHashesInLoop() {

        // Supply multiple IDs and message texts with known expected hashes.
        String[] ids = {
            "0012345678",
            "1212345678",
            "9912345678"
        };

        String[] messages = {
            "Hi Mike, can you join us tonight?",
            "Hello Sam, see you tomorrow!",
            "Good morning, have a great day."
        };

        String[] expectedHashes = {
            "00:0:HITONIGHT",
            "12:1:HELLOTOMORROW",
            "99:2:GOODDAY"
        };

        // Check every expected hash.
        for (int i = 0; i < ids.length; i++) {

            Message message = new Message(
                    ids[i],
                    "+271234567",
                    messages[i],
                    i
            );

            assertEquals(
                    expectedHashes[i],
                    message.createMessageHash()
            );
        }
    }

    @Test
    public void testSendMessage() {

        // Create a message and choose the send action.
        Message message = new Message(
                "0012345678",
                "+271234567",
                "Hello",
                0
        );

        assertEquals(
                "Message successfully sent.",
                message.sentMessage("1")
        );
    }

    @Test
    public void testDisregardMessage() {

        // Create a message and choose the disregard action.
        Message message = new Message(
                "0012345678",
                "+271234567",
                "Hello",
                0
        );

        assertEquals(
                "Press 0 to delete the message.",
                message.sentMessage("2")
        );
    }

    @Test
    public void testStoreMessage() {

        // Create a message and choose the store action.
        Message message = new Message(
                "0012345678",
                "+271234567",
                "Hello",
                0
        );

        assertEquals(
                "Message successfully stored.",
                message.sentMessage("3")
        );
    }

    @Test
    public void testInvalidMessageID() {

        // Create a message with an ID longer than ten characters.
        Message message = new Message(
                "12345678901",
                "+27123456789",
                "Hello",
                0
        );

        // The ID should be rejected.
        assertFalse(message.checkMessageID());
    }
}
