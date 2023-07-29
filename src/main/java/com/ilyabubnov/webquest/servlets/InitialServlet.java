package com.ilyabubnov.webquest.servlets;

import com.ilyabubnov.webquest.services.WorkingWithDataFromJson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import java.io.IOException;

@Log4j2
@WebServlet(name = "InitialServlet", value="/start")
public class InitialServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession httpSession = req.getSession(true);

        String ip = req.getHeader("X-Forwarded-For");
        if (ip == null) {
            req.getRemoteAddr();
        }

        httpSession.setAttribute("name", req.getParameter("name"));
        httpSession.setAttribute("IP", ip);
        httpSession.setAttribute("GamesPlayed", 0);
        httpSession.setAttribute("GamesWon", 0);
        httpSession.setAttribute("game", new WorkingWithDataFromJson());

        log.info("Session data: " + httpSession.getId() + " initialize. Game begin.");

        resp.sendRedirect("/game");
    }
}
