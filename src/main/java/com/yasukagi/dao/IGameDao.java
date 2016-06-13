package com.yasukagi.dao;

import java.util.List;

/**
 * Yasukagi.comで独自に保持するGameテーブルのDao
 */
public interface IGameDao {

  /**
   * GameをLimitの数だけ取得する．
   * @param limit 一回で取得する件数
   * @return ゲームのリスト
   */
  List<Game> findGameByLimit(Integer limit);
}
