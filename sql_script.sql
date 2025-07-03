-- Disable checks for safe table creation
SET FOREIGN_KEY_CHECKS=0;
SET UNIQUE_CHECKS=0;

-- Create and use database
CREATE DATABASE IF NOT EXISTS expenses_tracker;
USE expenses_tracker;

-- Table: category
CREATE TABLE IF NOT EXISTS category (
  id INT NOT NULL,
  name VARCHAR(255),
  PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Table: client
CREATE TABLE IF NOT EXISTS client (
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(255),
  first_name VARCHAR(255),
  last_name VARCHAR(255),
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=9;

-- Table: expense
CREATE TABLE IF NOT EXISTS expense (
  id INT NOT NULL AUTO_INCREMENT,
  amount INT,
  date_time VARCHAR(255),
  description VARCHAR(400),
  category_id INT,
  client_id INT,
  PRIMARY KEY (id),
  INDEX (category_id),
  INDEX (client_id),
  FOREIGN KEY (category_id) REFERENCES category(id),
  FOREIGN KEY (client_id) REFERENCES client(id)
) ENGINE=InnoDB AUTO_INCREMENT=16;

-- Table: role
CREATE TABLE IF NOT EXISTS role (
  id INT NOT NULL,
  name VARCHAR(255),
  PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Table: user
CREATE TABLE IF NOT EXISTS user (
  id INT NOT NULL AUTO_INCREMENT,
  password VARCHAR(255),
  user_name VARCHAR(255),
  client_id INT,
  enabled BIT,
  PRIMARY KEY (id),
  UNIQUE KEY (client_id),
  FOREIGN KEY (client_id) REFERENCES client(id)
) ENGINE=InnoDB AUTO_INCREMENT=9;

-- Table: users_roles
CREATE TABLE IF NOT EXISTS users_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  INDEX (role_id),
  INDEX (user_id),
  FOREIGN KEY (user_id) REFERENCES user(id),
  FOREIGN KEY (role_id) REFERENCES role(id)
) ENGINE=InnoDB;

-- Re-enable checks
SET FOREIGN_KEY_CHECKS=1;
SET UNIQUE_CHECKS=1;
