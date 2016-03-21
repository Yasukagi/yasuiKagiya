package com.yasukagi.dao;

import java.util.List;

public interface ISteamGameListDao {
    List<SteamGameList> findAll();
    int insert(SteamGameList steamGameList);
}
