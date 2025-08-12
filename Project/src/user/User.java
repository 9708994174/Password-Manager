package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import JDBCProject.JDBC;

/**
 * The User object holds all account info, including the account info for
 * logging into the password manager and all Internet account info.
 */
public class User {
    private Account account;
    private HashMap<String, InternetAccount> internetAccounts;

    // Constructor: initializes user account and loads associated InternetAccounts from the database
    public User(Account account) {
        this.account = account;
        this.internetAccounts = new HashMap<>();
        loadInternetAccountsFromDatabase();
    }

    /**
     * Loads the user's internet accounts from the database.
     */
    private void loadInternetAccountsFromDatabase() {
        String query = "SELECT Domain, Username, Password FROM internetaccountstable WHERE Username = ?";

        try (Connection con = JDBC.getMysqlConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setString(1, account.getUserName()); // Use username as the unique identifier
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String domain = rs.getString("Domain");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                internetAccounts.put(domain, new InternetAccount(domain, username, password));
            }
        } catch (SQLException e) {
            System.out.println("Error loading internet accounts from database.");
            e.printStackTrace();
        }
    }

    /**
     * @param domain
     * @return Returns the InternetAccount corresponding to the input domain.
     */
    public InternetAccount getInternetAccount(String domain) {
        return internetAccounts.get(domain);
    }

    /**
     * @return Returns this User's account.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @return Returns a HashMap of InternetAccounts.
     */
    public HashMap<String, InternetAccount> getInternetAccounts() {
        return internetAccounts;
    }

    /**
     * Adds an InternetAccount to the database and updates the local HashMap.
     *
     * @param internetAccount The InternetAccount to be added.
     */
    public void addInternetAccount(InternetAccount internetAccount) {
        String query = "INSERT INTO internetaccountstable (Username, Domain, Username, Password) VALUES (?, ?, ?, ?)";

        try (Connection con = JDBC.getMysqlConnection();
             PreparedStatement preparedStatement = con.prepareStatement(query)) {

            preparedStatement.setString(1, account.getUserName()); // Use username as the unique identifier
            preparedStatement.setString(2, internetAccount.getDomain());
            preparedStatement.setString(3, internetAccount.getUserName());
            preparedStatement.setString(4, internetAccount.getPasswordHash());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                internetAccounts.put(internetAccount.getDomain(), internetAccount);
                System.out.println("Internet account added successfully.");
            } else {
                System.out.println("Failed to add internet account.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding internet account to database.");
            e.printStackTrace();
        }
    }
}