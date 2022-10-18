package ru.kpfu.itis.tarasov.net.dao;

import ru.kpfu.itis.tarasov.net.model.BookRaiting;
import ru.kpfu.itis.tarasov.net.util.BookConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRaitingDao {
    private final Connection connection = BookConnectionUtil.getConnection();

    public List<BookRaiting> getinfo() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * From book_raiting ORDER BY mark DESC;";
            ResultSet resultSet = statement.executeQuery(sql);

            List<BookRaiting> booksRaiting = new ArrayList<>();
            BookRaiting raiting = null;
            while (resultSet.next()) {
                raiting = new BookRaiting(
                        resultSet.getInt("id"),
                        resultSet.getInt("book_id"),
                        resultSet.getInt("number_of_reviews"),
                        resultSet.getString("mark"),
                        resultSet.getString("name")
                );
                booksRaiting.add(raiting);
            }
            return booksRaiting;
        } catch (SQLException e) {
            return null;
        }
    }
}
