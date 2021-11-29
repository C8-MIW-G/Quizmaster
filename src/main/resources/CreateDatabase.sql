-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

DROP IF EXISTS SCHEMA `Quizmaster`;
CREATE SCHEMA `Quizmaster`;

CREATE TABLE `Quizmaster`.`User` (
        `userId` INT NOT NULL AUTO_INCREMENT,
        `username` VARCHAR(145) NOT NULL UNIQUE,
        `password` VARCHAR(45) NOT NULL,
        PRIMARY KEY (`userId`)
);

CREATE IF NOT EXISTS USER 'userQuizmaster'@'localhost' IDENTIFIED BY 'userQuizmasterPW';
GRANT ALL PRIVILEGES ON Quizmaster . * TO 'userQuizmaster'@'localhost';
