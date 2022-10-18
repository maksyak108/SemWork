package ru.kpfu.itis.tarasov.net.servlet;

import ru.kpfu.itis.tarasov.net.dao.BookDao;
import ru.kpfu.itis.tarasov.net.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "searchServlet", urlPatterns = "/search")

public class SearchServlet extends HttpServlet {

    public final BookDao bookDao = new BookDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("book", bookDao.getBook(""));
        req.getRequestDispatcher("search.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        Book book = new BookDao().getBook(name);
        if(book != null) {
            req.setAttribute("book", book);
            req.getRequestDispatcher("/search.ftl").forward(req, resp);
        }else{
            req.setAttribute("book", bookDao.getBook(""));
            req.getRequestDispatcher("/search.ftl").forward(req, resp);
        }
    }
}