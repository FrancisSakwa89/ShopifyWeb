<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 8/29/19
  Time: 8:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Response</title>
</head>
<body>
<jsp:useBean id="user" scope="session" class="com.franco.Bean.UserBean" />
<jsp:setProperty name="user" property="*" />
<h1>Hello, <jsp:getProperty name="user" property="username" />!</h1>
<jsp:forward page="home.jsp"></jsp:forward>
</body>
</html>
