package ru.kpfu.itis.tarasov.net.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.tarasov.net.dao.impl.UserDaoImpl;
import ru.kpfu.itis.tarasov.net.model.BookRaiting;
import ru.kpfu.itis.tarasov.net.util.BookConnectionUtil;
import ru.kpfu.itis.tarasov.net.util.PostgresConnectionUtil;

import java.sql.*;
import java.util.List;

public class ClientReviewDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private final Connection connection = PostgresConnectionUtil.getConnection();
    private final Connection bookConnection = BookConnectionUtil.getConnection();


    public void saveUserReview(String name, String review, String score) {
        String sql = "INSERT into client_review(book_name, review, score) VALUES (?, ?, ?);";
        String updateSql = "UPDATE book_raiting SET number_of_reviews = ?, mark = ? Where name = ?;";
        List<BookRaiting> bookRaitings = new BookRaitingDao().getinfo();
        double raiting = 0;
        int number = 0;
        for(int i = 0; i < bookRaitings.size(); i++){
            if(bookRaitings.get(i).getName().equals(name)){
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
            bookStatement.setString(3, name);

            bookStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.warn("Failed execute save query", e);
        }
    }

    public String save(String name, String review, String score){
        saveUserReview(name, review, score);
        return "Review about " +  name + " saved";
    }
}
