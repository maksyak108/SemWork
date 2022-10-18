package ru.kpfu.itis.tarasov.net.dao;

import ru.kpfu.itis.tarasov.net.model.KidsBook;
import ru.kpfu.itis.tarasov.net.util.KidsBookConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class KidsBookDao {
    private final Connection connection = KidsBookConnectionUtil.getConnection();

    public List<KidsBook> getinfo() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from kids_book";
            ResultSet resultSet = statement.executeQuery(sql);

            List<KidsBook> books = new ArrayList<>();
            KidsBook book = null;
            while (resultSet.next()) {
                book = new KidsBook(
                        resultSet.getInt("id"),
                        resultSet.getString("author"),
                        resultSet.getString("name"),
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
