package ru.kpfu.itis.tarasov.net.servlet;

import ru.kpfu.itis.tarasov.net.dao.ClientReviewDao;
import ru.kpfu.itis.tarasov.net.dao.PasswordDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        req.setAttribute("review", new ClientReviewDao().getClientReview((String) httpSession.getAttribute("username")));
        req.setAttribute("client", new PasswordDao().getinfo((String) httpSession.getAttribute("username")));
        req.getRequestDispatcher("profile.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        req.setCharacterEncoding("UTF-8");
        String info = req.getParameter("info");
        String name = info.substring(0, info.length() - 2);
        String score = info.substring(info.length() - 1);
        new ClientReviewDao().deleteUserReview(name, score, (String) httpSession.getAttribute("username"));
        req.setAttribute("review", new ClientReviewDao().getClientReview((String) httpSession.getAttribute("username")));
        req.setAttribute("client", new PasswordDao().getinfo((String) httpSession.getAttribute("username")));
        req.getRequestDispatcher("profile.ftl").forward(req, resp);
    }
}