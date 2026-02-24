# 🔐 Password Manager

A secure, user-friendly JavaFX desktop application for managing and organizing your passwords and credentials with ease.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#-key-features)
- [Project Structure](#-project-structure)
- [Technology Stack](#-technology-stack)
- [Getting Started](#-getting-started)
- [Usage](#usage)
- [Security](#-security-considerations)
- [Future Enhancements](#-future-enhancements)
- [Author](#-author)
- [License](#license)

## Overview

**Password Manager** is a desktop application built with **JavaFX** that provides a secure and intuitive interface for managing user credentials. Whether you need to store passwords for multiple accounts or organize sensitive information, this application offers a clean, professional solution.

### Why Use This?
✅ **Simple & Intuitive** – Easy-to-use interface for all skill levels  
✅ **Secure Storage** – Local file-based storage with encryption support  
✅ **Account Management** – Organize passwords by account type  
✅ **Fast & Responsive** – Desktop application with instant access  

---

## ✨ Key Features

- **User Registration & Authentication** – Secure user registration with email and password validation
- **Password Storage** – Save and organize passwords for different internet accounts
- **Account Management** – Add, edit, and delete saved accounts with ease
- **User-Friendly Interface** – Clean, modern JavaFX GUI with intuitive design
- **Data Persistence** – Passwords stored securely in local text files
- **Session Management** – Secure user session handling
- **Multi-Account Support** – Manage multiple accounts per user

---

## 🏗️ Project Structure

```
Password-Manager/
│
├── Project/
│   ├── src/
│   │   ├── controller/
│   │   │   └── *.java                    # JavaFX Controllers (UI logic)
│   │   │
│   │   ├── model/
│   │   │   ├── Colors.java               # UI color constants & theming
│   │   │   └── PasswordManagerModel.java # Core application model
│   │   │
│   │   ├── user/
│   │   │   ├── User.java                 # User entity class
│   │   │   ├── Account.java              # Account entity class
│   │   │   └── InternetAccount.java      # Internet account extension
│   │   │
│   │   ├── data/
│   │   │   ├── users.txt                 # User credentials storage
│   │   │   └── {email}.txt               # Account-specific password files
│   │   │
│   │   ├── view/
│   │   │   └── RegisterView.fxml         # User registration UI (FXML)
│   │   │
│   │   └── launcher/
│   │       └── Main.java                 # Application entry point
│   │
│   ├── bin/                              # Compiled bytecode
│   ├── .classpath                        # Project classpath configuration
│   └── .project                          # Eclipse project file
│
├── .gitignore
├── README.md
└── LICENSE
```

---

## 🛠️ Technology Stack

| Component | Technology |
|-----------|------------|
| **Language** | Java 11+ |
| **GUI Framework** | JavaFX |
| **UI Markup** | FXML |
| **Build System** | Eclipse IDE |
| **Data Storage** | Text Files (Extensible to Database) |
| **Optional** | JDBC/MySQL |

---

## 📦 Core Components

### Controllers
Manage user interactions and coordinate between the UI (View) and business logic (Model).

### Models
- **PasswordManagerModel.java** – Core application logic for password management
- **Colors.java** – UI color constants and consistent theming

### User Classes
- **User.java** – Represents a user with credentials
- **Account.java** – Base account class for storing account details
- **InternetAccount.java** – Extended account class for internet-based accounts

### View Layer
- **RegisterView.fxml** – Professional registration form with validation and styling

---

## 🚀 Getting Started

### Prerequisites

Before running the application, ensure you have:

- **Java 11 or higher** – [Download JDK](https://www.oracle.com/java/technologies/downloads/)
- **JavaFX SDK 15.0.1 or higher** – [Download JavaFX](https://gluonhq.com/products/javafx/)
- **Eclipse IDE** (or any Java IDE supporting JavaFX) – [Download Eclipse](https://www.eclipse.org/downloads/)
- **Git** – [Download Git](https://git-scm.com/)

### Installation & Setup

#### 1. Clone the Repository

```bash
git clone https://github.com/9708994174/Password-Manager.git
cd Password-Manager
```

#### 2. Import into Eclipse

1. Open **Eclipse IDE**
2. Go to `File` → `Import` → `General` → `Existing Projects into Workspace`
3. Select the `Password-Manager/Project` directory
4. Click `Finish`

#### 3. Configure JavaFX

1. Download **JavaFX SDK** from [gluonhq.com](https://gluonhq.com/products/javafx/)
2. In Eclipse:
   - Right-click the project → `Build Path` → `Configure Build Path`
   - Go to `Libraries` tab → `Add External JARs`
   - Navigate to your JavaFX SDK `lib` folder and add all `.jar` files
   - Add VM arguments: `-p /path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml`

#### 4. Run the Application

1. Navigate to `src/launcher/` directory
2. Locate the **Main.java** file
3. Right-click → `Run As` → `Java Application`

---

## Usage

### User Registration

1. Launch the application
2. Click on **Register** button
3. Enter your email and create a strong password
4. Verify your credentials and submit

### Storing Passwords

1. **Log in** with your credentials
2. Click **Add New Account**
3. Enter account details:
   - Account name (e.g., Gmail, Facebook)
   - Username/Email
   - Password
4. Click **Save**

### Managing Accounts

- **View** all saved accounts in the dashboard
- **Edit** existing account details
- **Delete** accounts you no longer need
- **Search** accounts quickly using the search bar

---

## 💾 Data Storage

User data is stored locally in text files within the `Project/src/data/` directory:

| File | Purpose |
|------|---------|
| **users.txt** | Stores registered user credentials |
| **{email}.txt** | Individual files containing each user's saved passwords |

> **Note:** For production use, consider migrating to a proper database system (MySQL, PostgreSQL).

---

## 🔒 Security Considerations

### Current Implementation ⚠️
- Passwords stored in plain text files (for demonstration purposes)

### Recommended Security Enhancements
- ✅ Implement **password encryption** using AES-256 or similar algorithms
- ✅ **Hash passwords** using bcrypt or PBKDF2 before storage
- ✅ Validate all **user inputs** to prevent injection attacks
- ✅ Use **HTTPS** if migrating to a web-based architecture
- ✅ Implement **Master Password** protection
- ✅ Add **Two-Factor Authentication (2FA)**
- ✅ Store sensitive data in a **secure database** rather than text files
- ✅ Implement **session timeouts** for enhanced security

---

## 🔄 Future Enhancements

- [ ] Database integration using JDBC/MySQL
- [ ] Password encryption with AES-256 algorithm
- [ ] Import/Export functionality for password backups
- [ ] Master password protection
- [ ] Password strength indicator
- [ ] Auto-fill password capability
- [ ] Two-Factor Authentication (2FA)
- [ ] Dark mode UI theme
- [ ] Password expiration reminders
- [ ] Biometric authentication support

---

## 🤝 Contributing

Contributions are welcome! If you'd like to improve this project:

1. **Fork** the repository
2. Create a **feature branch** (`git checkout -b feature/YourFeature`)  
3. **Commit** your changes (`git commit -m 'Add YourFeature'`)
4. **Push** to the branch (`git push origin feature/YourFeature`)
5. Open a **Pull Request**

---

## 👤 Author

**Rahul Kumar**  
Lovely Professional University  
[GitHub Profile](https://github.com/9708994174)

---

## 📝 License

This project is **open source** and available under the [MIT License](LICENSE).  
Feel free to use, modify, and distribute as needed.

---

## ⭐ Show Your Support

If you found this project helpful, please consider giving it a ⭐ **star** on GitHub!

---

**Last Updated:** 2026-02-24