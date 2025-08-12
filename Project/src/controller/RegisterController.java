// Updated RegisterController.java
package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.PasswordManagerModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterController {
    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordField1;
    @FXML
    private PasswordField passwordField2;  

    private PasswordManagerModel model;

    public void initialize(PasswordManagerModel model) {
        this.model = model;
    }

    /**
     * Handles the ENTER key press event for input fields.
     * 
     * @param event The key event triggered by the user.
     */
    @FXML
    public void fieldOnEnter(KeyEvent event) {
        if (event.getCode() == javafx.scene.input.KeyCode.ENTER) {
            mainButtonOnAction();
        }
    }
   
    /**
     * Changes button appearance when mouse enters.
     *
     * @param event The mouse event triggered by entering the button area.
     */
    @FXML
    public void mainButtonOnEnter(MouseEvent event) {
        System.out.println("Mouse entered the main button.");
    }

    /**
     * Changes button appearance when mouse exits.
     *
     * @param event The mouse event triggered by exiting the button area.
     */
    @FXML
    public void mainButtonOnExit(MouseEvent event) {
        System.out.println("Mouse exited the main button.");
    }

    public void mainButtonOnAction() {
        String email = emailTextField.getText();
        String password1 = passwordField1.getText();
        String password2 = passwordField2.getText();

        if (!password1.equals(password2)) {
            System.out.println("Passwords do not match.");
        } else if (email.isEmpty() || password1.isEmpty()) {
            System.out.println("Email or password cannot be empty.");
        } else {
            try {
                saveUserToDatabase(email, password1);
                System.out.println("User registered successfully!");
            } catch (SQLException e) {
                System.out.println("Error saving user to the database.");
                e.printStackTrace();
            }
        }
    }

    private void saveUserToDatabase(String email, String password) throws SQLException {
        String query = "INSERT INTO passwordmanagertable (Email, Password) VALUES (?, ?)";

        try (Connection con = JDBCProject.JDBC.getMysqlConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("User data saved successfully.");
            } else {
                System.out.println("Failed to save user data.");
            }
        }
    }
}
