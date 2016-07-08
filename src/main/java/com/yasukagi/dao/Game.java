package com.yasukagi.dao;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * gameテーブルの内容をマッピングするクラス
 */
public class Game {
  private final Integer gameId;
  private final String gameTitle;
  private final BigDecimal gamePriceSteam;
  private final BigDecimal gameCheapest;
  private final DateTime releaseDate;
  private final boolean isGame;

  public static class Builder {
    private Integer gameId;
    private String gameTitle;
    private BigDecimal gamePriceSteam;
    private  BigDecimal gameCheapest;
    private DateTime releaseDate;
    private boolean isGame;

    public Builder () {}

    public Builder gameId(Integer gameId) {
      this.gameId = gameId; return this;
    }
    public Builder gameTitle(String gameTitle) {
      this.gameTitle = gameTitle; return this;
    }
    public Builder gamePriceSteam(BigDecimal gamePriceSteam) {
      this.gamePriceSteam = gamePriceSteam; return this;
    }
    public Builder gameCheapest(BigDecimal gameCheapest) {
      this.gameCheapest = gameCheapest; return this;
    }
    public Builder releaseDate(DateTime releaseDate) {
      this.releaseDate = releaseDate; return this;
    }
    public Builder isGame(boolean isGame) {
      this.isGame = isGame; return this;
    }
    public Game build() {
      return new Game(this);
    }
  }

  private Game(Builder builder) {
    this.gameId = builder.gameId;
    this.gameTitle = builder.gameTitle;
    this.gamePriceSteam = builder.gamePriceSteam;
    this.gameCheapest = builder.gameCheapest;
    this.releaseDate = builder.releaseDate;
    this.isGame = builder.isGame;
  }

  public Integer getGameId() {
    return gameId;
  }

  public String getGameTitle() {
    return gameTitle;
  }

  public BigDecimal getGamePriceSteam() {
    return gamePriceSteam;
  }

  public BigDecimal getGameCheapest() {
    return gameCheapest;
  }

  public DateTime getReleaseDate() {
    return releaseDate;
  }

  public boolean isGame() {
    return isGame;
  }

  public BigDecimal getDiscountRate() {
    return gameCheapest.divide(gamePriceSteam, BigDecimal.ROUND_HALF_DOWN);
  }
}
