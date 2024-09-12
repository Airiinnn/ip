package chatbot.ui;

import chatbot.ChatBot;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for the main GUI.
 */
public class MainWindow extends AnchorPane {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private ChatBot chatBot;

    private final Image userImage = new Image(this.getClass().getResourceAsStream("/images/256x256.png"));
    private final Image chatBotImage= new Image(this.getClass().getResourceAsStream("/images/256x256.png"));

    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /**
     * Injects the Chatbot instance
     */
    public void setChatbot(ChatBot chatbot) {
        this.chatBot = chatbot;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing the chatbot's reply and then appends
     * them to the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = chatBot.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getChatBotDialog(response, chatBotImage)
        );
        userInput.clear();
    }

}
