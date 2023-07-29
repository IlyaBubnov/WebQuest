<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <title>Saw_TextQuest</title>
    <link rel="stylesheet" href="static/PageStyle.css">
  </head>
  <body>
    <h1 class="header"> SAW "Survival game" </h1>
      <div>
        "Те, кто не ценят жизнь, не достойны самой жизни." - Джон Крамер.
      </div>
    <br/>
    <h3 class="introduction"> Двое незнакомцев просыпаются в странном подвальном помещении. В центре помещения —
      труп мужчины с простреленной головой и оружием в ослабевшей руке. Они же прикованы к стенам цепями за
      щиколотки. Оба не знают, как там оказались. Твоя задача: как - то разрулить ситуацию и сохранить им жизнь.
      Или нет? </h3>
    <br>
    <form action="${pageContext.request.contextPath}/start" method="get">
      <label>
        <input type = "text" name = "name">
        <input type = "submit" value = "Call your name"/>
      </label>
    </form>
  </body>
</html>