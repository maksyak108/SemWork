package ru.kpfu.itis.tarasov.net.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.tarasov.net.dao.PasswordDao;
import ru.kpfu.itis.tarasov.net.util.PasswordUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("login.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = PasswordUtil.encrypt(req.getParameter("password"));
        String remember = req.getParameter("rememberMe");
        String PASSWORD = new PasswordDao().getPassword(email);


        if (PASSWORD.equals(password)) {
            logger.info("User with username = {} logged in", email);
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("username", email);
                httpSession.setMaxInactiveInterval(60 * 60);
                if(remember != null) {
                Cookie httpCookie = new Cookie("username", email);
                httpCookie.setMaxAge(24 * 60 * 60);
                resp.addCookie(httpCookie);
            }
            resp.sendRedirect("/profile");
        } else {
            resp.sendRedirect("/modalError");
        }
    }
}
