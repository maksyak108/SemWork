package ru.kpfu.itis.tarasov.net.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.tarasov.net.dao.impl.UserDaoImpl;
import ru.kpfu.itis.tarasov.net.model.Book;
import ru.kpfu.itis.tarasov.net.model.BookRaiting;
import ru.kpfu.itis.tarasov.net.util.BookConnectionUtil;
import ru.kpfu.itis.tarasov.net.util.PostgresConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class ClientReviewDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private final Connection connection = PostgresConnectionUtil.getConnection();
    private final Connection bookConnection = BookConnectionUtil.getConnection();

//    public User getinfo(String email) {
//        try {
//            Statement statement = connection.createStatement();
//            String sql = "SELECT * from client WHERE mail = '" + email + "'";
//            ResultSet resultSet = statement.executeQuery(sql);
//
//            User user = null;
//            while (resultSet.next()) {
//                user = new User(
//                        resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getString("mail"),
//                        resultSet.getString("password")
//                );
//            }
//            if(user == null){
//                user = new User("DOESNTEXIST!", "DOESNTEXIST!", "DOESNTEXIST!");
//            }
//            return user;
//        } catch (SQLException e) {
//            LOGGER.warn("Failed execute get all query", e);
//            return null;
//        }
//    }

    public void saveUserReview(String name, String review, String score, int bookId) {
        String sql = "INSERT into client_review(book_name, review, score) VALUES (?, ?, ?);";
        String updateSql = "UPDATE book_raiting SET number_of_reviews = ?, mark = ? Where book_id = ?;";
        ArrayList<BookRaiting> bookRaitings = new BookRaitingDao().getinfo();
        double raiting = 0;
        int number = 0;
        for(int i = 0; i < bookRaitings.size(); i++){
            if(bookRaitings.get(i).getBookId() == bookId){
                raiting = Double.parseDouble(bookRaitings.get(i).getMark());
                number = bookRaitings.get(i).getNumberOfReviews();
            }
        }
        raiting = (raiting * number + Integer.parseInt(score)) / (number + 1);
        number += 1;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, review);
            preparedStatement.setInt(3, Integer.parseInt(score));
            preparedStatement.executeUpdate();

            PreparedStatement bookStatement = bookConnection.prepareStatement(updateSql);
            bookStatement.setInt(1, number);
            bookStatement.setString(2, String.valueOf(raiting));
            bookStatement.setInt(3, bookId);

            bookStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Failed execute save query", e);
        }
    }

    public String save(String name, String review, String score, int bookId){
        saveUserReview(name, review, score, bookId);
        return "Review about " +  name + " saved";
    }
}
