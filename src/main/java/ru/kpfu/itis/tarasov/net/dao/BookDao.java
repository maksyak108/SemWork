package ru.kpfu.itis.tarasov.net.dao;

import ru.kpfu.itis.tarasov.net.model.Book;
import ru.kpfu.itis.tarasov.net.util.BookConnectionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private final Connection connection = BookConnectionUtil.getConnection();

    public List<Book> getinfo() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from book";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Book> books = new ArrayList<>();
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

    public Book getBook(String name) {
        List<Book> books = getinfo();
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getName().equals(name)){
                return books.get(i);
            }
        }
        return null;
    }
}
