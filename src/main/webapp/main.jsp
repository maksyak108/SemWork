<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main page</title>
</head>
<body>

<%
    String user = null;
    String sessionUser = (String) session.getAttribute("username");

    if (sessionUser == null) {
        response.sendRedirect("login.html");
    } else {
        response.sendRedirect("profile.html");
    }

%>

</body>
</html>
