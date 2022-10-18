package ru.kpfu.itis.tarasov.net.servlet;

import ru.kpfu.itis.tarasov.net.dao.KidsBookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "forKidsServlet", urlPatterns = "/forKids")

public class ForKidsServlet extends HttpServlet {

    public final KidsBookDao kidsbookDao = new KidsBookDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("book", kidsbookDao.getinfo());
        req.getRequestDispatcher("forKids.ftl").forward(req, resp);
    }
}
