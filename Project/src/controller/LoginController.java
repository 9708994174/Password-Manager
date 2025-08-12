package controller;

import JDBCProject.JDBC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Colors;
import model.PasswordManagerModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController extends SmallWindowController {

    @FXML
    private Button registerButton;

    @FXML
    BorderPane borderPane;

    PasswordManagerModel model;
    Stage regStage;

    /**
     * Default constructor.
     */
    public LoginController() {
        model = new PasswordManagerModel();
        System.out.println("New model created");
    }

    //=============== Login button =====================================================================================

    /**
     * Opens the main password manager window and validates user credentials using the database.
     */
    @Override
    public void mainButtonOnAction() {
        String username = usernameTextField.getText();
        String password = passwordField1.getText();

        if (validateLogin(username, password)) {
            model.setUser(model.getUser(username));
            System.out.println("Logged in: " + model.getCurrentUser());
            openMainWindow();
        } else {
            invalidLabel.setVisible(true);
            invalidLabel.setText("Invalid login. Please try again.");
        }
    }

    /**
     * Validates login credentials by querying the database.
     *
     * @param username The entered username.
     * @param password The entered password.
     * @return true if credentials are valid, false otherwise.
     */
    private boolean validateLogin(String username, String password) {
        String query = "SELECT Password FROM passwordmanagertable WHERE Email = ?";

        try (Connection con = JDBC.getMysqlConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("Password");
                return storedPassword.equals(password); // Consider using hashed password comparison
            }
        } catch (SQLException e) {
            System.out.println("Error validating login.");
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Opens the main password manager window.
     */
    private void openMainWindow() {
        try {
            String viewPath = PasswordManagerModel.VIEW_DIRECTORY + "MainView.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
            Stage mainStage = new Stage();
            Parent parent = loader.load();
            MainController mainController = loader.getController();
            mainController.initialize(model);
            mainStage.setTitle("Password Manager");
            mainStage.setScene(new Scene(parent));
            mainStage.setResizable(false);
            mainStage.show();
            mainButton.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //================ Register button =================================================================================

    /**
     * Opens register window.
     */
    public void registerButtonAction() {
        System.out.println("Registering new user");
        try {
            String viewPath = PasswordManagerModel.VIEW_DIRECTORY + "RegisterView.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
            regStage = new Stage();
            Parent parent = loader.load();

            // Get the controller and pass the PasswordManagerModel
            RegisterController regController = loader.getController();
            regController.initialize(model);

            regStage.setTitle("Register");
            regStage.setScene(new Scene(parent));
            regStage.setResizable(false);
            regStage.show();
            borderPane.setDisable(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Allows color changes when mouse hovers over button.
     */
    public void registerButtonOnEnter() { registerButton.setStyle(Colors.setBackgroundColor(Colors.LIGHT_GREY)); }

    public void registerButtonOnExit() { registerButton.setStyle(Colors.setBackgroundColor(Colors.WHITE)); }

}