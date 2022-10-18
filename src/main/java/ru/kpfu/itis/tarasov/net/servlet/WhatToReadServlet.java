package ru.kpfu.itis.tarasov.net.servlet;

import ru.kpfu.itis.tarasov.net.dao.BookRaitingDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "whatToReadServlet", urlPatterns = "/whatToRead")

public class WhatToReadServlet extends HttpServlet {

    public final BookRaitingDao bookRaitingDao = new BookRaitingDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("book", bookRaitingDao.getinfo());
        req.getRequestDispatcher("whatToRead.ftl").forward(req, resp);
    }
}
