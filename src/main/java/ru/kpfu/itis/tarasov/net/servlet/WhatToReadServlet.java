package ru.kpfu.itis.tarasov.net.servlet;

import ru.kpfu.itis.tarasov.net.dao.BookRaitingDao;
import ru.kpfu.itis.tarasov.net.dao.ClientReviewDao;
import ru.kpfu.itis.tarasov.net.model.Review;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "whatToReadServlet", urlPatterns = "/whatToRead")

public class WhatToReadServlet extends HttpServlet {

    public final BookRaitingDao bookRaitingDao = new BookRaitingDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("book", bookRaitingDao.getinfo());
        List<Review> reviews = new ArrayList<>();
        req.setAttribute("review", reviews);
        req.getRequestDispatcher("whatToRead.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        List<Review> reviews = new ClientReviewDao().getinfo(name);
        req.setAttribute("book", bookRaitingDao.getinfo());
        req.setAttribute("review", reviews);
        req.getRequestDispatcher("whatToRead.ftl").forward(req, resp);
    }
}
