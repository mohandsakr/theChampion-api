CREATE TABLE `champion`.`champion_participant` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(225) NULL,
  `mail` VARCHAR(225) NULL,
   `group_id` INT NULL DEFAULT NULL ,
  PRIMARY KEY (`id`));
