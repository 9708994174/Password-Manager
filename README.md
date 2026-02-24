🔐 Password Manager
A JavaFX-based desktop application for securely managing user credentials and passwords. This project provides a user-friendly interface for registering users, storing passwords, and managing multiple internet accounts.

📋 Overview
This Password Manager application is built with JavaFX for the GUI and Java for the backend logic. It allows users to register, log in, and manage their passwords for various internet accounts with a clean, intuitive interface.

🏗️ Project Structure
Code
Password-Manager/
│
├── Project/
│   ├── src/
│   │   ├── controller/           # JavaFX Controllers (handles UI logic)
│   │   ├── model/                # Data models
│   │   │   ├── Colors.java       # Color constants for UI theming
│   │   │   └── PasswordManagerModel.java  # Core application model
│   │   ├── user/                 # User-related classes
│   │   │   ├── User.java         # User entity class
│   │   │   ├── Account.java      # Account entity class
│   │   │   └── InternetAccount.java  # Internet account extension
│   │   ├── data/                 # Data storage
│   │   │   ├── users.txt         # User credentials storage
│   │   │   └── *.txt             # Account-specific password files
│   │   ├── view/                 # JavaFX FXML files
│   │   │   └── RegisterView.fxml # User registration UI
│   │   ├── launcher/             # Application entry point
│   │   └── JDBCProject/          # Database connectivity (optional)
│   │
│   ├── bin/                      # Compiled bytecode
│   ├── .classpath                # Project classpath configuration
│   └── .project                  # Eclipse project file
│
└── README.md
✨ Key Features
User Registration & Authentication – Secure user registration with email and password validation
Password Storage – Save and organize passwords for different internet accounts
Account Management – Add, edit, and delete saved accounts
User-Friendly Interface – Clean JavaFX GUI with intuitive design
Data Persistence – Passwords stored in local text files (with potential for database enhancement)
Session Management – User session handling for security
🛠️ Technology Stack
Language: Java
GUI Framework: JavaFX
UI Definition: FXML (JavaFX Markup Language)
Build System: Eclipse IDE (.classpath, .project)
Data Storage: Text files (users.txt, account-specific files)
Optional: JDBC for database integration
📦 Core Components
Controllers
Handles user interactions and communicates between the UI and business logic.

Models
PasswordManagerModel.java – Core application logic for password management
Colors.java – UI color constants and theming
User Classes
User.java – Represents a user with credentials
Account.java – Base account class for storing account details
InternetAccount.java – Extended account class for internet-based accounts
View Layer
RegisterView.fxml – Registration form with email and password fields, styled with a professional color scheme
🚀 Getting Started
Prerequisites
Java 11 or higher
JavaFX SDK 15.0.1 or higher
Eclipse IDE or any Java IDE supporting JavaFX
Installation & Setup
Clone the repository

bash
git clone https://github.com/9708994174/Password-Manager.git
Import into Eclipse

File → Import → General → Existing Projects into Workspace
Select the Password-Manager/Project directory
Configure JavaFX

Download JavaFX SDK from javafx.io
Add JavaFX library to your project's build path
Run the Application

Locate the launcher class in src/launcher/
Right-click → Run As → Java Application
💾 Data Storage
User data is stored in text files within the Project/src/data/ directory:

users.txt – Stores registered user credentials
{email}.txt – Individual files for each user's saved passwords
🔒 Security Considerations
Implement password encryption/hashing before storage
Use HTTPS if moving to a web-based architecture
Validate all user inputs to prevent injection attacks
Consider implementing JDBC with a proper database instead of text files for production use
🔄 Future Enhancements
Database integration using JDBC/MySQL
Password encryption with AES or similar algorithms
Export/Import functionality for password backups
Master password protection
Password strength indicator
Auto-fill password capability
👤 Author
Rahul Kumar
Lovely Professional University

📝 License
This project is open source. Feel free to use, modify, and distribute as needed.
