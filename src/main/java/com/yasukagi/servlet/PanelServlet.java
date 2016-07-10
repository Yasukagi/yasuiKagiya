package com.yasukagi.servlet;

import com.yasukagi.MainPanelHtmlGen;
import com.yasukagi.comparator.ReleaseDiscountComp;
import com.yasukagi.dao.Game;
import com.yasukagi.dao.GameDao;
import com.yasukagi.utils.Configure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

public class PanelServlet extends HttpServlet{
  private static final Configure config = new Configure("html_generator.properties");
  private static final Logger logger = LogManager.getLogger(PanelServlet.class);
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    GameDao dao = new GameDao();
    List<Game> games = dao.findGameByLimit(config.getIntConfig("display.game.number"));
    Collections.sort(games, new ReleaseDiscountComp(new DateTime()));
    MainPanelHtmlGen htmlGen = MainPanelHtmlGen.getInstance();
    out.println(htmlGen.createHtml(games));
    // TODO: リクエストに関する情報を出すようにする
    logger.info("get request");
  }
}
