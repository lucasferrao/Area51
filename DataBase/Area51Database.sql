DROP TABLE IF EXISTS recluse;
DROP TABLE IF EXISTS visitor;
DROP TABLE IF EXISTS visit;
DROP TABLE IF EXISTS officer;
DROP TABLE IF EXISTS occurrence;
DROP TABLE IF EXISTS device;
DROP TABLE IF EXISTS alert;



CREATE TABLE IF NOT EXISTS recluse (
    id_recluse INT AUTO_INCREMENT PRIMARY KEY,
    recluse_name VARCHAR(100) NOT NULL,
    birthdate DATE NOT NULL,
    genre VARCHAR(10) NOT NULL,
    disease VARCHAR(50) NOT NULL,
    cause VARCHAR(50) NOT NULL,
    cell VARCHAR(5) NOT NULL
);

CREATE TABLE IF NOT EXISTS visitor (
    id_visitor INT AUTO_INCREMENT PRIMARY KEY,
    visitor_name VARCHAR(100) NOT NULL,
    nif INT NOT NULL
);

CREATE TABLE IF NOT EXISTS visit (
    id_visit INT AUTO_INCREMENT PRIMARY KEY,
    id_recluse INT AUTO_INCREMENT PRIMARY KEY,
    id_visitor INT AUTO_INCREMENT PRIMARY KEY,
    visit_date DATE NOT NULL,
    checkin TIME NOT NULL,
    checkout TIME NOT NULL,
    FOREIGN KEY (id_recluse)
		REFERENCES login (id_recluse)
        ON DELETE CASCADE,
    FOREIGN KEY (id_visitor)
		REFERENCES login (id_visitor)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS officer (
    id_officer INT AUTO_INCREMENT PRIMARY KEY,
    id_officer_login VARCHAR(10)  NOT NULL,
    email VARCHAR(50)  NOT NULL,
    login_password VARCHAR(20)  NOT NULL,
    officer_address VARCHAR(100)  NOT NULL,
    phone_number INT NOT NULL
);

CREATE TABLE IF NOT EXISTS occurrence (
    id_occurrence INT AUTO_INCREMENT PRIMARY KEY,
    occurrence_description VARCHAR(255) NOT NULL,
    occurrence_subject VARCHAR(100) NOT NULL,
    occurrence_date DATE NOT NULL,
    id_recluse INT AUTO_INCREMENT PRIMARY KEY,
    id_officer INT AUTO_INCREMENT PRIMARY KEY,
    FOREIGN KEY (id_recluse)
		REFERENCES login (id_recluse)
        ON DELETE CASCADE,
    FOREIGN KEY (id_officer)
		REFERENCES login (id_officer)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS device (
    id_device INT AUTO_INCREMENT PRIMARY KEY,
    device_type VARCHAR(20) NOT NULL,
    model VARCHAR(10) NOT NULL,
    device_location VARCHAR(20) NOT NULL,
    repair_history VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS alert (
    id_alert INT AUTO_INCREMENT PRIMARY KEY,
    alert_type VARCHAR(20) NOT NULL,
    alert_date DATE NOT NULL,
    alert_date TIME(7) NOT NULL,
    id_officer INT AUTO_INCREMENT PRIMARY KEY,
    id_device INT AUTO_INCREMENT PRIMARY KEY,
    FOREIGN KEY (id_recluse)
		REFERENCES login (id_recluse)
        ON DELETE CASCADE,
    FOREIGN KEY (id_device)
		REFERENCES login (id_device)
        ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS occurrence_by_alert (
    id_occurrence_by_alert INT AUTO_INCREMENT PRIMARY KEY,
    id_occurrence INT AUTO_INCREMENT PRIMARY KEY,
    id_alert INT AUTO_INCREMENT PRIMARY KEY,
    FOREIGN KEY (id_occurrence)
		REFERENCES login (id_occurrence)
        ON DELETE CASCADE,
    FOREIGN KEY (id_alert)
		REFERENCES login (id_alert)
        ON DELETE CASCADE
);
