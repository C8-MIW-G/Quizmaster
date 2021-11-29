-- noinspection SqlNoDataSourceInspectionForFile
-- noinspection SqlDialectInspectionForFile

DROP SCHEMA IF EXISTS `Quizmaster`;
CREATE SCHEMA `Quizmaster`;

CREATE USER IF NOT EXISTS 'userQuizmaster'@'localhost' IDENTIFIED BY 'userQuizmasterPW';
GRANT ALL PRIVILEGES ON Quizmaster . * TO 'userQuizmaster'@'localhost';
