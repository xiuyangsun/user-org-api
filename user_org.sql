CREATE DATABASE  IF NOT EXISTS `user_org_directory`;
USE `user_org_directory`;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone`  varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `organization`;

CREATE TABLE `organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `user_org`;

CREATE TABLE `user_org` (
  `user_id` int(11) NOT NULL,
  `org_id` int(11) NOT NULL,
  
  PRIMARY KEY (`user_id`,`org_id`),
  
  FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  FOREIGN KEY (`org_id`) 
  REFERENCES `organization` (`id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
);
