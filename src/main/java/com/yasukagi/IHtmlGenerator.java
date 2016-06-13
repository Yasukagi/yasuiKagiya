package com.yasukagi;


import com.yasukagi.dao.Game;

import java.util.List;
/**
 * ゲームリストを表示するHTMLを生成するインタフェース．
 * 表示する部分毎に生成するHTMLは変わるので，それに合わせて継承しましょう
 */
public interface IHtmlGenerator {
  String createHtml(List<Game> games);
}
