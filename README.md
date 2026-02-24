# Password Manager

A secure, efficient, and user-friendly **Password Manager** web application built using **Java Servlets, JSP, HTML, and CSS**.  
This project securely stores, retrieves, and manages user credentials while offering a clean UI and essential password management features.

---

## 🚀 Features
- **User Authentication** – Register, login, and logout securely.
- **Password Storage** – Save credentials for different accounts securely.
- **Encryption** – Store passwords using secure hashing/encryption algorithms.
- **Search & Filter** – Easily find saved credentials.
- **Edit & Delete** – Manage saved accounts.
- **Responsive UI** – Built with HTML & CSS for cross-device compatibility.
- **Session Management** – Ensures security for logged-in users.

---

## 🛠️ Tech Stack
- **Frontend**: HTML, CSS, JSP
- **Backend**: Java Servlets
- **Database**: MySQL
- **Server**: Apache Tomcat

---

## 📂 Project Structure
```

Password\_Manager/
│
├── src/                # Java source code
│   ├── controller/     # Servlets
│   ├── dao/            # Database access
│   └── model/          # Data models
│
├── WebContent/         # Frontend files
│   ├── css/            # Stylesheets
│   ├── js/             # Scripts
│   └── jsp/            # JSP pages
│
└── README.md           # Project documentation

````

---

## ⚙️ Installation & Setup
1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/Password-Manager.git
````

2. **Import into an IDE** (Eclipse / IntelliJ IDEA)
3. **Configure Database**

   * Create a MySQL database (e.g., `password_manager`)
   * Import the provided `schema.sql` file
   * Update `DBConfig.java` with your DB credentials
4. **Deploy on Apache Tomcat**
5. **Run the project** and open in browser:

   ```
   http://localhost:8080/Password_Manager
   ```

---

## 🔒 Security Considerations

* Use **AES encryption** for password storage.
* Implement **HTTPS** for secure data transmission.
* Enable **CSRF & XSS protection** in forms.

---

## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss your ideas.


