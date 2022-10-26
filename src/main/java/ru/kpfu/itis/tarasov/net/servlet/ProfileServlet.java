package ru.kpfu.itis.tarasov.net.servlet;

import ru.kpfu.itis.tarasov.net.dao.ClientReviewDao;
import ru.kpfu.itis.tarasov.net.dao.PasswordDao;
import ru.kpfu.itis.tarasov.net.model.Review;
import ru.kpfu.itis.tarasov.net.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "profileServlet", urlPatterns = "/profile")

public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession httpSession = req.getSession();
        req.setAttribute("review", new ClientReviewDao().getClientReview((String) httpSession.getAttribute("username")));
        req.setAttribute("client", new PasswordDao().getinfo((String) httpSession.getAttribute("username")));
        req.getRequestDispatcher("profile.ftl").forward(req, resp);
    }

}
