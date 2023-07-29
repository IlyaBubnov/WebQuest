<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.ilyabubnov.webquest.model.GameStatus" %>

<%--
  Created by IntelliJ IDEA.
  User: Ilich
  Date: 26.07.2023
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>

<html>
    <head>
        <link href="${pageContext.request.contextPath}/static/PageStyle.css" rel="stylesheet">
        <title>SAW "Survival game"</title>
    </head>
    
    <body>
    <c:if test="${!sessionScope.game.gameOver()}" var="isGameNotOver" scope="request">
        <form action="${pageContext.request.contextPath}/game" method="post">
            <h1>${sessionScope.game.getPhrase()}</h1>
            <br>
            <input type="radio" id="first_opportunity" name="answer" value=1 checked>
            <label for="first_opportunity">
                    ${sessionScope.game.getMessageFromFirstOpportunity()}
            </label>
            <br>
            <input type="radio" id="second_opportunity" name="answer" value=2>
            <label for="second_opportunity">
                    ${sessionScope.game.getMessageFromSecondOpportunity()}
            </label>
            <br>
            <input type="submit" value="Answer"/>
        </form>
    </c:if>
        <c:if test="${!requestScope.gameOver()}">
            <c:set var="gamesPlayed" value="${sessionScope.gamesPlayed+1}" scope="session"/>
        <c:if test="${sessionScope.game.getActualGameStatus() == GameStatus.WIN}">
            <c:set var="gamesWon" value="${sessionScope.gamesWon+1}" scope="session"/>
        </c:if>
        <h1>${sessionScope.game.getPhrase()}</h1>
        <h1>${sessionScope.game.getGameResult()}</h1>
        <form action="${pageContext.request.contextPath}/restart" method="post">
            <input type="submit" value="Wanna play again?"/>
        </form>
    </c:if>
    <div>
        <p>Statistics:</p>
        <p>IP address: ${sessionScope.IP}</p>
        <p>Name: ${sessionScope.name}</p>
        <p>Games: ${sessionScope.GamesPlayed}</p>
        <p>Wins: ${sessionScope.GamesWon}</p>
    </div>
    </body>
</html>
