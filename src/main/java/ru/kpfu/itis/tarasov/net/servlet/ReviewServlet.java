package ru.kpfu.itis.tarasov.net.servlet;

import ru.kpfu.itis.tarasov.net.dao.ClientReviewDao;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "reviewServlet", urlPatterns = "/review")
public class ReviewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("review.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String review = req.getParameter("review");
        String score = req.getParameter("score");
        HttpSession httpSession = req.getSession();
        new ClientReviewDao().saveUserReview(name, review, score, (String) httpSession.getAttribute("username"));
        resp.sendRedirect("profile.html");
    }
}
