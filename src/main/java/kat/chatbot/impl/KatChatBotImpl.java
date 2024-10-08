package kat.chatbot.impl;

import kat.chatbot.ChatBot;
import kat.chatbot.MessageParser;
import kat.exceptions.InvalidMessageException;

/**
 * Implements the ChatBot interface representing a chatbot named Kat.
 * This class handles user interactions, processes input, and generates responses.
 */
public class KatChatBotImpl implements ChatBot {

    private static final String GREETING_RESPONSE = "Hi! I'm Kat.\nHow can I help?";

    private static final String ENDING_COMMAND = "bye";

    private final MessageParser messageParser;

    /**
     * Constructs a new KatChatBotImpl with the specified scanner and message parser.
     *
     * @param messageParser The MessageParser object for processing user messages
     */
    public KatChatBotImpl(MessageParser messageParser) {
        this.messageParser = messageParser;
    }

    @Override
    public String getWelcome() {
        return GREETING_RESPONSE;
    }

    /**
     * Processes the user input and generates an appropriate response.
     *
     * @param input The user's input string to be processed.
     * @return A string containing the chatbot's response to the user's input.
     */
    @Override
    public String getResponse(String input) {
        try {
            return messageParser.handleMessage(input);
        } catch (InvalidMessageException e) {
            return e.getMessage();
        }
    }

    @Override
    public boolean isTerminationCommand(String input) {
        return input.equalsIgnoreCase(ENDING_COMMAND);
    }

}
