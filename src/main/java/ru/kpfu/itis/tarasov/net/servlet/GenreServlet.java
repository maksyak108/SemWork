package ru.kpfu.itis.tarasov.net.servlet;

import ru.kpfu.itis.tarasov.net.dao.BookDao;
import ru.kpfu.itis.tarasov.net.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "genreServlet", urlPatterns = "/genre")

public class GenreServlet extends HttpServlet {

    public final BookDao bookDao = new BookDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("book", bookDao.getinfo());
        req.getRequestDispatcher("genre.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        String genre = req.getParameter("genre");
        List<Book> books = new BookDao().getinfo();
        List<Book> book = new ArrayList<>();
        if (genre.equals("Все")) {
            req.setAttribute("book", books);
            req.getRequestDispatcher("/genre.ftl").forward(req, resp);
        } else {
            for (int i = 0; i < books.size(); i++){
                if(books.get(i).getGanre().equals(genre)){
                    book.add(books.get(i));
                }
            }
        }
        req.setAttribute("book", book);
        req.getRequestDispatcher("/genre.ftl").forward(req, resp);
    }
}
