-- noinspection SqlNoDataSourceInspectionForFile
-- noinspection SqlDialectInspectionForFile

DROP SCHEMA IF EXISTS `QuizmasterTest`;
CREATE SCHEMA `QuizmasterTest`;

CREATE USER IF NOT EXISTS 'userQuizmasterTest'@'localhost' IDENTIFIED BY 'userQuizmasterPW';
GRANT ALL PRIVILEGES ON QuizmasterTest . * TO 'userQuizmasterTest'@'localhost';
