package com.ilyabubnov.webquest.servlets;

import com.ilyabubnov.webquest.services.WorkingWithDataFromJson;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import java.io.IOException;

@WebServlet (name = "GameServlet", value = "/game")
@Log4j2
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/game.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession httpSession = req.getSession();

        int answer = Integer.parseInt(req.getParameter("answer"));

        WorkingWithDataFromJson workingWithDataFromJson = (WorkingWithDataFromJson) httpSession.getAttribute("game");
        workingWithDataFromJson.choiceOfOption(answer);

        log.info("User from sessionId " + httpSession.getId() + " made the choice.");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/game.jsp");
        requestDispatcher.forward(req, resp);
    }
}
