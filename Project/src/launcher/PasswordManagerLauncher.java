package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.PasswordManagerModel;
   
public class PasswordManagerLauncher extends Application {

    @Override
    public void start(Stage loginStage) throws Exception {
        String loginDirectory = PasswordManagerModel.VIEW_DIRECTORY + "LoginView.fxml";

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(loginDirectory));
            Parent parent = loader.load();
            loginStage.setScene(new Scene(parent));
            loginStage.setResizable(false);
            loginStage.setTitle("Password Manager - Login");  
            loginStage.show();
        } catch (Exception e) {
            System.out.println("Error loading LoginView.fxml");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
