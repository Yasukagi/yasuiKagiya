package com.yasukagi;

import com.yasukagi.dao.SteamGameList;
import com.yasukagi.dao.SteamGameListDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * スライダー式のメインコンテンツとして表示するパネルを制御するサーブレット
 */
//TODO: DBとの接続を制御できるように
public class MainGamelistPanelServlet extends AbstractPanelServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    out.println(createHtml());
  }

  @Override
  protected String createHtml() {
    StringBuilder buf = new StringBuilder();

    SteamGameListDao dao = new SteamGameListDao();
    List<SteamGameList> list = dao.findAll();
    for (SteamGameList steamGameList : list) {
      buf.append("<li>\n");
      buf.append("<a href='./app/gametitle'>\n");
      buf.append("<img src='http://placehold.it/640x360' alt='gametitle'>\n");
      buf.append("<div class='gametitle'>\n");
      buf.append(steamGameList.getGameTitle());
      buf.append("\n");
      buf.append("</div>\n");
      buf.append("<div class='price'>\n");
      buf.append(steamGameList.getGamePrice());
      buf.append("</div>\n");
      buf.append("</a>\n");
      buf.append("</li>\n");
    }

    return buf.toString();
  }
}
