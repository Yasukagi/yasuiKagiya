package com.yasukagi.dao;

import com.yasukagi.utils.Configure;

import java.sql.*;

/**
 * データベースへ接続するためのクラス
 */
public class DaoConnector {
  private static final Configure config = new Configure("database.properties");
  private static final String driver = config.getStringConfig("db.driver.class");
  private static final String userName = config.getStringConfig("db.user.name");
  private static final String userPass = config.getStringConfig("db.user.pass");
  private static final String port = config.getStringConfig("db.port");

  private final Statement smt;

  public DaoConnector(String dbName)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
    Class.forName(driver).newInstance();
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + dbName, userName, userPass);
     this.smt = con.createStatement();
  }

  /**
   * データベースへクエリを発行する
   * （データベースとのコネクションを取得したあと，クエリを発行している）
   * @param sql クエリ文字列
   * @return クエリの結果
   */
  public ResultSet executeQuery(String sql) throws SQLException {
    return smt.executeQuery(sql);
  }
}
