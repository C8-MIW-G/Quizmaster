package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import model.User;

public class WelcomeController {

    @FXML
    private Label welcomeLabel;
    @FXML
    private MenuButton taskMenuButton;

    public void setup() {
        welcomeLabel.setText("Welkom " + User.loggedInUser.getUsername());
    }

    public void doLogout() {}
}
