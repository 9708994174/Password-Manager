package user;

/**
 * Secure implementation of the Account object. 
 */
public class Account {

    private String username;
    private String passwordHash; // Store hashed password for security

    public Account(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
    }

    /**
     * @return Returns the username of this Account.
     */
    public String getUserName() {
        return this.username;
    }

    /**
     * @return Returns the hashed password of this Account.
     */
    public String getPasswordHash() {
        return this.passwordHash;
    }

    /**
     * Changes the password for this Account and updates the hashed password.
     * @param newPassword The new password to set.
     */
    public void changePassword(String newPassword) {
        this.passwordHash = hashPassword(newPassword); // Use a method to hash the password
    }

    /**
     * Validates a given password against the stored hashed password.
     * @param password The password to validate.
     * @return True if the password matches, false otherwise.
     */
    public boolean validatePassword(String password) {
        return this.passwordHash.equals(hashPassword(password)); // Compare hashed values
    }

    /**
     * Hashes a password using a secure algorithm (placeholder implementation).
     * @param password The password to hash.
     * @return The hashed password.
     */
    private String hashPassword(String password) {
        // Replace with actual hashing logic (e.g., BCrypt, PBKDF2, etc.)
        return Integer.toHexString(password.hashCode());
    }
}
