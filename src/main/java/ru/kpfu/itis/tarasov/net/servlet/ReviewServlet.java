package ru.kpfu.itis.tarasov.net.servlet;

import ru.kpfu.itis.tarasov.net.dao.BookDao;
import ru.kpfu.itis.tarasov.net.dao.ClientReviewDao;
import ru.kpfu.itis.tarasov.net.dao.PasswordDao;
import ru.kpfu.itis.tarasov.net.model.Book;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
        ArrayList<Book> books = new BookDao().getinfo();
        String result = null;
        for (int i = 0; i < books.size(); i++){
            if(books.get(i).getName().equals(name)){
                result = new ClientReviewDao().save(name, review, score, books.get(i).getId() + 1);
            }
        }
        if(result != null){
            resp.sendRedirect("index.html");
        }else {
            resp.sendRedirect("modalError.html");
        }
    }
}
