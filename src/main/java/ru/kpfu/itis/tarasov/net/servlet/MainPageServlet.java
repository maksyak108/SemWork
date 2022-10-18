package ru.kpfu.itis.tarasov.net.servlet;

import ru.kpfu.itis.tarasov.net.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mainPageServlet", urlPatterns = "/mainPage")

public class MainPageServlet extends HttpServlet {
    public final BookDao bookDao = new BookDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("book", bookDao.getinfo());
        req.getRequestDispatcher("mainPage.ftl").forward(req, resp);
    }
}
