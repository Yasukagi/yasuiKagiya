package com.yasukagi;

import com.yasukagi.dao.Game;

import java.util.List;

public class SubPanelHtmlGen implements IHtmlGenerator {

  public String createHtml(List<Game> games) {
    StringBuilder sb = new StringBuilder();
    for (Game game : games) {
      sb.append("<li>\n");
      sb.append("<a href='./app/gametitle'>\n");
      sb.append("<img src='http://placehold.it/640x360' alt='gametitle'>\n");
      sb.append("<div class='gametitle'>\n");
      sb.append(game.getGameTitle());
      sb.append("\n");
      sb.append("</div>\n");
      sb.append("<div class='price'>\n");
      sb.append(game.getGameCheapest());
      sb.append("</div>\n");
      sb.append("</a>\n");
      sb.append("</li>\n");
    }
    return sb.toString();
  }
}

