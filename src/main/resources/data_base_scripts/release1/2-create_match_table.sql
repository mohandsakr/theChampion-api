CREATE TABLE `champion`.`champion_match` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_team_id` INT NULL,
  `second_team_id` INT NULL,
  `round_id` INT NULL,
  `winner_id` INT NULL,
  PRIMARY KEY (`id`));
