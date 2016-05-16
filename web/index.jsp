<%@ page import="com.goit.gojavaonline.testproject.Main" %>
<%@ page import="database.DBWorker" %><%--
  Created by IntelliJ IDEA.
  User: артур
  Date: 14.05.2016
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Онлайн калькулятор</title>
</head>
<body BGCOLOR="#ffffcc">
<% if (request.getParameter("formula")== null ) { %>
<center>
  <h2>Онлайн калькулятор</h2>
  <form METHOD="GET" ACTION="index.jsp" >
    <fieldset style="border:1px #00BFFF solid;" >
    <p>
      Формула: <input type="text" name="formula" size=26>

    <p>
      <input type="submit" value="Расчитать">
      </p>
      </fieldset>
  </form>
</center>
<% } else { %>
<%! String formula;
  String result;%>
<%
  formula = request.getParameter("formula");

%>
<center>
<p>
  <b>Онлайн калькулятор</b>:
<p>
  <fieldset style="border:1px #00BFFF solid;">
  <b>Формула</b>: <%= formula %><P>
  <b>Результат</b>: <%= result = Main.test(formula) %>
    <% } %>
    <%! private int accessCount = 0; %>

  </center>


</fieldset>
<center><p> Количество обращений к странице с момента загрузки сервера: <%= ++accessCount %> </p></center>
</body>
</html>