package com.yasukagi.servlet;

import com.yasukagi.dao.SteamGameList;
import com.yasukagi.dao.SteamGameListDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class testServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SteamGameListDao dao = new SteamGameListDao();
        List<SteamGameList> list = dao.findAll();
        resp.getWriter().println("HELLO YASUI KAGIYA");
        resp.getWriter().println("====Game List====");
        for (Iterator<SteamGameList> it = list.iterator(); it.hasNext(); ) {
            SteamGameList steamGameList = it.next();
            resp.getWriter().println("APP_ID:" + steamGameList.getAppId());
            resp.getWriter().println("TITLE:" + steamGameList.getGameTitle());
        }
    }
}