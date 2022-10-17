package ru.kpfu.itis.tarasov.net.dao;

import ru.kpfu.itis.tarasov.net.model.Book;
import ru.kpfu.itis.tarasov.net.model.User;
import ru.kpfu.itis.tarasov.net.util.BookConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDao {
    private final Connection connection = BookConnectionUtil.getConnection();

    public ArrayList<Book> getinfo() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from book";
            ResultSet resultSet = statement.executeQuery(sql);

            ArrayList<Book> books = new ArrayList<>();
            Book book = null;
            while (resultSet.next()) {
                book = new Book(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("name"),
                        resultSet.getString("ganre"),
                        resultSet.getString("description")
                );
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            return null;
        }
    }
}
