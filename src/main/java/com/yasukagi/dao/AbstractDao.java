package com.yasukagi.dao;


/**
 * 全てのDaoによって継承されるクラス
 * Daoに共通する機能はここにまとめる
 */
public class AbstractDao {
  protected final DbConnection dao;

  /**
   * コンストラクタ
   * @param dbName データベース名
   */
  public AbstractDao(String dbName) {
    this.dao = new DbConnection(dbName);
  }
}
