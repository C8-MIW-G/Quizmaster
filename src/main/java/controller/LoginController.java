package controller;

import database.mysql.UserDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.User;
import view.Main;

public class LoginController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField passwordField;

    public void doLogin() {
        Main.getDbAccess().openConnection();
        UserDAO userDAO = new UserDAO(Main.getDbAccess());
        User user = userDAO.confirmUserIdentity(nameTextField.getText(), passwordField.getText());
        Main.getDbAccess().closeConnection();

        User.setLoggedInUser(user);
        Main.getSceneManager().showWelcomeScene();
    }

    public void doQuit() {}
}
