package com.yasukagi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SteamGameListDao implements iSteamGameListDao {

    private List<SteamGameList> convert(ResultSet rs) throws SQLException{
        List<SteamGameList> list = new ArrayList<>();
        while(rs.next()) {
            SteamGameList steamGameList = new SteamGameList();
            steamGameList.setAppId(rs.getInt("app_id"));
            steamGameList.setGameTitle(rs.getString("game_title"));
            list.add(steamGameList);
        }
        return list;
    }

    public List<SteamGameList> findAll() {
        String sql = "SELECT * FROM steam_gamelist";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_yasukagi", "root", "root");
            Statement smt = con.createStatement();
            return convert(smt.executeQuery(sql));
        } catch (SQLException e){
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }
    public int insert(SteamGameList steamGameList) {
        String sql = "INSERT INTO steam_gamelist(app_id,game_list)"
                + " VALUES("
                + steamGameList.getAppId() + ","
                + "'" + steamGameList.getGameTitle() + "')";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_yasukagi", "root", "root");
            Statement smt = con.createStatement();
            return smt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }
}
