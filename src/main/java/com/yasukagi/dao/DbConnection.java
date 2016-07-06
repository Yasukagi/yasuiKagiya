package com.yasukagi.dao;

import com.yasukagi.utils.Configure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

/**
 * データベースへ接続するためのクラス
 * 使い方：
 * DaoConnectorインスタンスを生成し，
 * 実際にDaoインスタンスを作る際は，このインスタンスを渡す
 */
public class DbConnection {
  private final Configure config = new Configure("database.properties");
  private Statement smt;

  private static final Logger logger = LogManager.getLogger(DbConnection.class);

  /**
   * コンストラクタ. DBを指定する
   * @param dbName データベース名
   */
  public DbConnection(String dbName) {
    String driver = config.getStringConfig("db.driver.class");
    String port = config.getStringConfig("db.port");
    String userPass = config.getStringConfig("db.user.pass");
    String userName = config.getStringConfig("db.user.name");

    try {
      Class.forName(driver).newInstance();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/" + dbName + "?autoReconnect=true&useSSL=false", userName, userPass);
      this.smt = con.createStatement();
    } catch (IllegalAccessException | InstantiationException | SQLException | ClassNotFoundException e) {
      logger.error(e.getMessage(), e);
    }
  }

  /**
   * コンストラクタ．DBは選択しない
   */
  public DbConnection() {
    String driver = config.getStringConfig("db.driver.class");
    String port = config.getStringConfig("db.port");
    String userPass = config.getStringConfig("db.user.pass");
    String userName = config.getStringConfig("db.user.name");

    try {
      Class.forName(driver).newInstance();
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "?autoReconnect=true&useSSL=false", userName, userPass);
      this.smt = con.createStatement();
    } catch (IllegalAccessException | ClassNotFoundException | SQLException | InstantiationException e) {
      logger.error(e.getMessage(), e);
    }
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

  public int executeUpdate(String sql) throws SQLException {
    return smt.executeUpdate(sql);
  }
}
