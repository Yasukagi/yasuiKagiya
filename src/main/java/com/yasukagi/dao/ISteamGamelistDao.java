package com.yasukagi.dao;

import java.util.List;

public interface iSteamGameListDao {
    List<SteamGameList> findAll();
    int insert(SteamGameList steamGameList);
}
