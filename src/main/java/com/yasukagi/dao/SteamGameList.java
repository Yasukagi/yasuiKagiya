package com.yasukagi.dao;

/**
* steam_gamelistテーブルに紐付くオブジェクト
**/
public class SteamGameList {

    private Integer appId;
    private String gameTitle;

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

}
