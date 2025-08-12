package model;

import user.Account;
import user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import JDBCProject.JDBC;

/**
 * This class is the model and stores all the information by interacting with the database. 
 * It also manages user-related operations.
 *
 * 
 */
public class PasswordManagerModel {

    private Map<String, User> userMap = new HashMap<>();
    private User currentUser; // the current user, i.e., whoever logged in

    public static final String VIEW_DIRECTORY = "../view/";

    public PasswordManagerModel() {
        loadUsersFromDatabase();
    }

    /**
     * Sets the current user when you log in.
     *
     * @param user The user object to set as the current user.
     */
    public void setUser(User user) {
        this.currentUser = user;
    }

    /**
     * @return Returns the current user, i.e., whoever is logged in.
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * @return Returns the username of the current user.
     */
    public String getCurrentUserName() {
        if (currentUser != null && currentUser.getAccount() != null) {
            return currentUser.getAccount().getUserName();
        }
        return null;
    }

    /**
     * Loads all users from the database into memory.
     */
    private void loadUsersFromDatabase() {
        String query = "SELECT Email, Password FROM passwordmanagertable";

        try (Connection con = JDBC.getMysqlConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query);
             ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                String email = rs.getString("Email");
                String passwordHash = rs.getString("Password");
                userMap.put(email, new User(new Account(email, passwordHash)));
            }
        } catch (SQLException e) {
            System.out.println("Error loading users from database.");
            e.printStackTrace();
        }
    }

    /**
     * @param email The email to check for existence.
     * @return Returns true if there is a User with the input email in the database, false otherwise.
     */
    public boolean hasUser(String email) {
        return userMap.containsKey(email);
    }

    /**
     * @param email The email of the user to retrieve.
     * @return Returns the User object that corresponds to the input email.
     */
    public User getUser(String email) {
        return userMap.get(email);
    }

    /**
     * Validates if the entered password matches the stored password for a given email.
     *
     * @param email The email of the user.
     * @param enteredPassword The entered password.
     * @return Returns true if the input password matches the database password, false otherwise.
     */
    public boolean isCorrectPassword(String email, String enteredPassword) {
        User user = userMap.get(email);
        return user != null && user.getAccount().validatePassword(enteredPassword);
    }

}