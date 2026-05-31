# 🍳 CookGenie

A full-stack recipe web application built with Java Spring Boot, MySQL, and Thymeleaf.

## 🚀 Features

- **User Authentication** — Register and login with secure BCrypt password encryption
- **Recipe Search** — Search recipes by name using TheMealDB API
- **Ingredient-Based Search** — Find recipes based on available ingredients
- **YouTube Suggestions** — Watch recipe tutorial videos directly from the app
- **Save Favorites** — Save and manage your favorite recipes
- **Responsive UI** — Clean and modern orange-themed interface

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 26, Spring Boot 4.1.0 |
| Frontend | Thymeleaf, HTML, CSS |
| Database | MySQL 8.0 |
| Security | Spring Security, BCrypt |
| API | TheMealDB API |
| Build Tool | Maven |
| Version Control | Git & GitHub |

## 📁 Project Structure

```
cookgenie/
├── src/
│   ├── main/
│   │   ├── java/com/cookgenie/
│   │   │   ├── CookgenieApplication.java
│   │   │   ├── AuthController.java
│   │   │   ├── HomeController.java
│   │   │   ├── FavoriteController.java
│   │   │   ├── SecurityConfig.java
│   │   │   ├── User.java
│   │   │   ├── UserRepository.java
│   │   │   ├── UserService.java
│   │   │   ├── Favorite.java
│   │   │   └── FavoriteRepository.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── home.html
│   │       │   ├── login.html
│   │       │   ├── register.html
│   │       │   └── favorites.html
│   │       ├── static/css/
│   │       │   └── style.css
│   │       └── application.properties
└── pom.xml
```

## ⚙️ Setup & Installation

### Prerequisites
- Java 17+
- Maven
- MySQL 8.0

### Steps

1. **Clone the repository**
```bash
git clone https://github.com/mohammedriyass/cookgenie.git
cd cookgenie
```

2. **Create MySQL database**
```sql
CREATE DATABASE cookgenie_db;
```

3. **Configure application.properties**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cookgenie_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

4. **Run the application**
```bash
mvn spring-boot:run
```

5. **Open in browser**
```
http://localhost:8080
```

## 📸 Screenshots



### Login Page
- Clean orange gradient UI
- Secure login with Spring Security

  <img width="1361" height="639" alt="image" src="https://github.com/user-attachments/assets/dce25905-f9d7-4cb2-9538-fe94e9c57e95" />


### Home Page
- Search recipes by name
- Search recipes by ingredients
- Recipe cards with images and YouTube links

  <img width="1362" height="631" alt="image" src="https://github.com/user-attachments/assets/dc2803cf-79a1-4005-9c6b-5ebe11bb3453" />


### Favorites Page
- Save your favorite recipes
- Remove recipes from favorites

  <img width="1361" height="635" alt="image" src="https://github.com/user-attachments/assets/9bd6ae03-4e10-413b-822a-dfebff1bd516" />


## 🔗 API Used

- **TheMealDB** — [https://www.themealdb.com/api.php](https://www.themealdb.com/api.php)
  - Free API, no key required
  - Recipe search by name and ingredients
  - Includes meal images and YouTube tutorial links

## 👨‍💻 Developer

**Mohammed Riyas**
- Registration: 711524BCB033
- Department: Computer Science and Business Systems (CSBS)

## 📄 License

This project is for educational purposes.
