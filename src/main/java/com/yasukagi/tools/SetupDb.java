package com.yasukagi.tools;

import com.yasukagi.dao.DbConnection;
import com.yasukagi.utils.Configure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 データベースセットアップスクリプト
 必要なデータベースを任意のユーザに対して生成する．yasukagiServletの初回セットアップ時には必ず実行しましょう．
 **/
public class SetupDb {
  private static final Logger logger = LogManager.getLogger(SetupDb.class);
  public static void main(String[] args) {
    Configure config = new Configure("database.properties");
    String rootDir = System.getProperty("user.dir");
    try {
      DbConnection db = new DbConnection();
      //データベース作成
      String dbName =  config.getStringConfig("db.name");
      String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
      db.executeUpdate(sql);
      logger.info("CREATE " + dbName);

      //resourcesディレクトリ以下のsqlを全て実行する
      File[] dir = new File(rootDir + "/src/main/resources/").listFiles();
      if (dir == null) {
        logger.warn("no sql files remaining");
        return;
      }

      DbConnection dao = new DbConnection(dbName);
      for(File file : dir) {
        if(!file.getName().endsWith(".sql"))
          continue;
        try {
          sql = new Scanner(file).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
          logger.error(e.getMessage(), e);
          continue;
        }
        dao.executeUpdate(sql);
        logger.info("CREATE " + file.getName());
      }
    } catch (SQLException e) {
      logger.error(e.getMessage(), e);
    }
  }
}
