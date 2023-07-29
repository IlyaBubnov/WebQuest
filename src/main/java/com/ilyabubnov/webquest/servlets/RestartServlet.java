package com.ilyabubnov.webquest.servlets;

import com.ilyabubnov.webquest.services.WorkingWithDataFromJson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import java.io.IOException;

@WebServlet(name = "RestartServlet", value = "/restart")
@Log4j2
public class RestartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("game", new WorkingWithDataFromJson());
        log.info("Game for sessionID: " + httpSession.getId() + " restart.");
        resp.sendRedirect("/game");
    }
}
