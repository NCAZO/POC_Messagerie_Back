CREATE DATABASE IF NOT EXISTS db_yourcaryourway;
USE db_yourcaryourway;

CREATE TABLE User (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Agency (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(100)
);

CREATE TABLE Vehicle (
    id INT PRIMARY KEY AUTO_INCREMENT,
    model VARCHAR(255) NOT NULL,
    disponibility BOOLEAN DEFAULT TRUE,
    agence_id INT,
    FOREIGN KEY (agence_id) REFERENCES Agency(id)
);

CREATE TABLE Reservation (
    id INT PRIMARY KEY AUTO_INCREMENT,
    start_res DATETIME NOT NULL,
    end_res DATETIME NOT NULL,
    status VARCHAR(50),
    user_id INT,
    vehicle_id INT,
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (vehicle_id) REFERENCES Vehicle(id)
);

CREATE TABLE ChatSession (
    id INT PRIMARY KEY AUTO_INCREMENT,
    start_chat DATETIME,
    end_chat DATETIME,
    user_id INT,
    res_id INT,
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (res_id) REFERENCES Reservation(id)
);

CREATE TABLE ChatMessage (
    id INT PRIMARY KEY AUTO_INCREMENT,
    content TEXT,
    timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,
    session_id INT,
    user_id INT,
    res_id INT,
    FOREIGN KEY (session_id) REFERENCES ChatSession(id),
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (res_id) REFERENCES Reservation(id)
);

CREATE TABLE SupportTicket (
    id INT PRIMARY KEY AUTO_INCREMENT,
    subject VARCHAR(255),
    message TEXT,
    status VARCHAR(50),
    res_id INT,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (res_id) REFERENCES Reservation(id)
);