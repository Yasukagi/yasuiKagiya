CREATE TABLE IF NOT EXISTS `game` (
  `game_id` int(11) NOT NULL,
  `game_title` varchar(255) NOT NULL,
  `game_price_steam` decimal(15,2) unsigned NOT NULL,
  `game_cheapest` decimal(15,2) unsigned NOT NULL,
  `release_date` date DEFAULT NULL,
  `is_game` tinyint(1) NOT NULL,
  `time_stamp` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8