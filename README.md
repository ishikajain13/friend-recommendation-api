# Friend Recommendation API (Spring Boot)

## 📌 Overview

The **Friend Recommendation API** is a backend service built using **Spring Boot** that manages users and provides friend recommendations based on predefined logic.

This project demonstrates a **RESTful API architecture**, clean layering, and backend best practices suitable for mid-level backend development.

---

## 🚀 Features

* User management (create, fetch users)
* Friend recommendation endpoint
* RESTful API design
* Layered architecture (Controller → Service → Repository)
* Exception handling
* Scalable backend structure

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 / MySQL (configurable)
* Maven

---

## 📂 Project Structure

```
src/main/java/com/example/friendrecommendation
│
├── controller       # REST Controllers
├── service          # Business logic
├── repository       # Data access layer
├── model            # Entity classes
├── dto              # Data Transfer Objects
├── exception        # Custom exception handling
└── FriendRecommendationApplication.java
```

---

## ⚙️ Setup & Installation

### 1. Clone the repository

```
git clone https://github.com/ishikajain13/friend-recommendation-api.git
cd friend-recommendation-api
```

### 2. Build the project

```
mvn clean install
```

### 3. Run the application

```
mvn spring-boot:run
```

---

## 🌐 API Endpoints

### 🔹 Create User

```
POST /users
```

**Request Body:**

```
{
  "name": "John"
}
```

---

### 🔹 Get All Users

```
GET /users
```

---

### 🔹 Get Friend Recommendations

```
GET /recommendations/{userId}
```

---

## 📌 Sample Response

```
[
  {
    "id": 2,
    "name": "Alice"
  },
  {
    "id": 3,
    "name": "Bob"
  }
]
```

---

## 🧱 Architecture

This project follows a **layered architecture**:

* **Controller Layer** → Handles HTTP requests/responses
* **Service Layer** → Contains business logic
* **Repository Layer** → Handles database interactions

This separation improves:

* Maintainability
* Testability
* Scalability

---

## ⚠️ Error Handling

* Centralized exception handling using `@ControllerAdvice`
* Meaningful HTTP status codes
* Validation-ready structure

---

## 🔧 Future Improvements

* Add authentication (Spring Security)
* Improve recommendation algorithm
* Add pagination & filtering
* Integrate caching (Redis)
* Dockerize the application

---

## 👩‍💻 Author

**Ishika Jain**

---

## 📄 License

This project is open-source and available under the MIT License.
