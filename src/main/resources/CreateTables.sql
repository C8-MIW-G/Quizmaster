-- noinspection SqlNoDataSourceInspectionForFile
-- noinspection SqlDialectInspectionForFile

CREATE TABLE `User` (
    `userId` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(145) NOT NULL UNIQUE,
    `password` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`userId`)
);