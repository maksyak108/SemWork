<%@ page import="ru.kpfu.itis.tarasov.net.dao.PasswordDao" %>
<%@ page import="ru.kpfu.itis.tarasov.net.model.Review" %>
<%@ page import="java.util.List" %>
<%@ page import="ru.kpfu.itis.tarasov.net.dao.ClientReviewDao" %>
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
        request.setAttribute("review",  new ClientReviewDao().getClientReview((String) session.getAttribute("username")));
        request.setAttribute("client", new PasswordDao().getinfo((String) session.getAttribute("username")));
        request.getRequestDispatcher("profile.ftl").forward(request, response);
    }

%>

</body>
</html>
