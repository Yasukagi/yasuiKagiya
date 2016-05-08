package com.yasukagi.dao;

import java.math.BigDecimal;

/**
* steam_gamelistテーブルに紐付くオブジェクト
**/
public class SteamGameList {

    private Integer appId;
    private String gameTitle;
    private BigDecimal gamePrice;

    public Integer getAppId() {
        return appId;
    }
    public void setAppId(Integer appId) {
        this.appId = appId;
    }
    public String getGameTitle() {
        return gameTitle;
    }
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }
    public BigDecimal getGamePrice() {
        return gamePrice;
    }
    public void setGamePrice(BigDecimal gamePrice) {
        this.gamePrice = gamePrice;
    }
}
