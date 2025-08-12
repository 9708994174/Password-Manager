package controller;

import JDBCProject.JDBC;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import launcher.PasswordManagerLauncher;
import model.PasswordManagerModel;
import user.InternetAccount;
import user.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MainController {
    Stage addPassStage;
    private User user;

    @FXML
    private Button addNewPasswordButton;

    @FXML
    private VBox passwordsVBox;

    @FXML
    private Button logoutButton;

    @FXML
    private BorderPane borderPane;

    /**
     * Transfers the PasswordManagerModel object from the LoginController class to
     * the MainController class, initializes the current user, and loads passwords.
     *
     * @param model The PasswordManagerModel instance.
     */
    public void initialize(PasswordManagerModel model) {
        System.out.println("Model transferred from login window to main window");
        this.user = model.getCurrentUser(); // Load the currently logged-in user
        System.out.println("Current User: " + user.getAccount().getUserName());
        loadPasswordsFromDatabase();
    }

    /**
     * @return Returns the current user object.
     */
    public User getUser() {
        return user;
    }

    /**
     * Loads passwords from the database and populates the UI.
     */
    private void loadPasswordsFromDatabase() {
        String query = "SELECT Domain, Username FROM internetaccountstable";

        try (Connection con = JDBC.getMysqlConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String domain = rs.getString("Domain");
                String username = rs.getString("Username");
                InternetAccount internetAccount = new InternetAccount(domain, username, "");
                addPasswordHBox(internetAccount);
            }
        } catch (SQLException e) {
            System.out.println("Error loading passwords from database.");
            e.printStackTrace();
        }
    }

    /**
     * Opens the window for adding new passwords.
     */
    public void addNewPasswordButtonAction() {
        System.out.println("Adding new password...");
        try {
            String viewPath = PasswordManagerModel.VIEW_DIRECTORY + "AddPassView.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(viewPath));
            addPassStage = new Stage();
            Parent parent = loader.load();
            AddPassController addPassController = loader.getController();
            addPassController.initialize(this);
            addPassStage.setTitle("Add Password");
            addPassStage.setScene(new Scene(parent));
            addPassStage.setResizable(false);
            addPassStage.show();
            borderPane.setDisable(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Logs the current user out and returns to the login window.
     *
     * @throws Exception If there is an issue launching the login window.
     */
    public void logoutButtonAction() throws Exception {
        logoutButton.getScene().getWindow().hide();
        PasswordManagerLauncher pml = new PasswordManagerLauncher();
        pml.start(new Stage());
    }

    /**
     * Adds an HBox that displays the domain, username button, and password button.
     *
     * @param internetAccount The InternetAccount to be displayed.
     */
    void addPasswordHBox(InternetAccount internetAccount) {
        try {
            String hboxViewDir = PasswordManagerModel.VIEW_DIRECTORY + "UserHBoxView.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(hboxViewDir));
            HBox hbox = loader.load();
            UserHBoxController userHBoxController = loader.getController();
            userHBoxController.initialize(internetAccount);
            passwordsVBox.getChildren().add(hbox);
            ((Label) hbox.getChildren().get(0)).setText(internetAccount.getDomain());
            HBox subHBox = (HBox) hbox.getChildren().get(1);
            ((Button) (subHBox.getChildren().get(0))).setText(internetAccount.getUserName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
