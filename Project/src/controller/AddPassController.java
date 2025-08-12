package controller;

import javafx.fxml.FXML;

//responsible for managing the functionality of a screen (or part of the UI) 
//where the user can add a new internet account (domain, username, password) to a database.

import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import model.PasswordManagerModel;
import user.InternetAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddPassController {

    @FXML
    private TextField domainTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;

    private MainController parentController;

    public void initialize(MainController parentController) {
        this.parentController = parentController;
    }

    @FXML
    public void fieldOnEnter(KeyEvent event) {
        if (event.getCode() == javafx.scene.input.KeyCode.ENTER) {
            mainButtonOnAction();
        }
    }

    @FXML
    public void mainButtonOnAction() {
        String domain = domainTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        if (domain.isEmpty() || username.isEmpty() || password.isEmpty()) {
            System.out.println("All fields are required!");
        } else {
            try {
                saveInternetAccountToDatabase(domain, username, password);
                parentController.addPasswordHBox(new InternetAccount(domain, username, password));
                System.out.println("Password saved successfully!");
            } catch (SQLException e) {
                System.out.println("Error saving password to the database.");
                e.printStackTrace();
            }
        }
    }

    private void saveInternetAccountToDatabase(String domain, String username, String password) throws SQLException {
        String query = "INSERT INTO internetaccountstable (Domain, Username, Password) VALUES (?, ?, ?)";

        try (Connection con = JDBCProject.JDBC.getMysqlConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setString(1, domain);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Internet account saved successfully.");
            } else {
                System.out.println("Failed to save internet account.");
            }
        }
    }

    @FXML
    public void mainButtonOnEnter(KeyEvent event) {
        System.out.println("Mouse entered the main button area.");
    }

    @FXML
    public void mainButtonOnExit(KeyEvent event) {
        System.out.println("Mouse exited the main button area.");
    }
}
