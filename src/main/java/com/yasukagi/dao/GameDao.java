package com.yasukagi.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDao extends AbstractDao implements IGameDao {
  private static final Logger logger = LogManager.getLogger(GameDao.class);

  public GameDao() {
    super("db_yasukagi");
  }

  private List<Game> convert(ResultSet rs) throws SQLException {
    List<Game> list = new ArrayList<>();
    while(rs.next()) {
      Game game = new Game.Builder()
          .gameId(rs.getInt("game_id"))
          .gameTitle(rs.getString("game_title"))
          .gamePriceSteam(rs.getBigDecimal("game_price_steam"))
          .gameCheapest(rs.getBigDecimal("game_cheapest"))
          .releaseDate(new DateTime(rs.getDate("release_date")))
          .isGame(rs.getBoolean("is_game")).build();
      list.add(game);
    }
    return list;
  }

  @Override
  public List<Game> findGameByLimit(Integer limit) {
    String sql = "SELECT * FROM game LIMIT " + limit;
    List<Game> result = new ArrayList<>();
    try {
      result = convert(dao.executeQuery(sql));
    } catch (SQLException e) {
      logger.error(e.getMessage(), e);
    }
    logger.info(sql + " => " + result.size());
    return result;
  }
}
