package com.yasukagi;

import javax.servlet.http.HttpServlet;

/**
 * ゲームリストを表示するパネルを制御するサーブレット
 * メインで表示するパネル（スライダー式のパネル），サブとして表示するパネルなど
 * 用途に応じて，このクラスを継承し実装する．
 */
public abstract class AbstractPanelServlet extends HttpServlet {

  abstract String createHtml();
}
