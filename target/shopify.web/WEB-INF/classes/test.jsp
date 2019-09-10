<%@ page import="java.util.Calendar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: moringaschool
  Date: 9/3/19
  Time: 11:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
<body>

<body>

<%
    out.println("scripltletTags printed");
    %>
    <%! int divide(){
        int a = 25;
        int b = 5;
        int c = a/b;
        return c;

}
 %>

<%=
divide()

%>
<% out.print("Today is:"+java.util.Calendar.getInstance().getTime()); %>

<c:set value="<%= Calendar.getInstance().get(Calendar.SECOND)%>" var="seconds"/>
<c:choose>
    <c:when test="${seconds le 30 }">
        <c:out value="${seconds} is less than 30"/>
    </c:when>
    <c:when test="${seconds eq 30 }">
        <c:out value="${seconds} is equal to 30"/>
    </c:when>
    <c:otherwise>
        <c:out value="${seconds} is greater than 30"/>
    </c:otherwise>
</c:choose>



</body>
</body>
</body>
</html>
