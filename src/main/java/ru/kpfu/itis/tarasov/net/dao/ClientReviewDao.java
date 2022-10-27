package ru.kpfu.itis.tarasov.net.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.kpfu.itis.tarasov.net.dao.impl.UserDaoImpl;
import ru.kpfu.itis.tarasov.net.model.BookRaiting;
import ru.kpfu.itis.tarasov.net.model.Review;
import ru.kpfu.itis.tarasov.net.util.BookConnectionUtil;
import ru.kpfu.itis.tarasov.net.util.PostgresConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientReviewDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);
    private final Connection connection = PostgresConnectionUtil.getConnection();
    private final Connection bookConnection = BookConnectionUtil.getConnection();


    public void saveUserReview(String name, String review, String score, String client_name) {
        String sql = "INSERT into client_review(book_name, review, score, client_name) VALUES (?, ?, ?, ?);";
        String updateSql = "UPDATE book_raiting SET number_of_reviews = ?, mark = ? Where name = ?;";
        List<BookRaiting> bookRaitings = new BookRaitingDao().getinfo();
        for (int o = 0; o < bookRaitings.size(); o++) {
            if (bookRaitings.get(o).getName().equals(name)) {
                double raiting = 0;
                int number = 0;
                for (int i = 0; i < bookRaitings.size(); i++) {
                    if (bookRaitings.get(i).getName().equals(name)) {
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
                    preparedStatement.setString(4, client_name);
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
        }
    }

    public List<Review> getinfo(String name) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from client_review";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Review> reviews = new ArrayList<>();
            Review review = null;
            while (resultSet.next()) {
                review = new Review(
                        resultSet.getInt("id"),
                        resultSet.getString("book_name"),
                        resultSet.getString("review"),
                        resultSet.getInt("score"),
                        resultSet.getString("client_name")
                );
                if(review.getBook_name().equals(name)) {
                    reviews.add(review);
                }
            }
            return reviews;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Review> getClientReview(String name) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * from client_review";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Review> reviews = new ArrayList<>();
            Review review = null;
            while (resultSet.next()) {
                review = new Review(
                        resultSet.getInt("id"),
                        resultSet.getString("book_name"),
                        resultSet.getString("review"),
                        resultSet.getInt("score"),
                        resultSet.getString("client_name")
                );
                if(review.getClient_name().equals(name)) {
                    reviews.add(review);
                }
            }
            return reviews;
        } catch (SQLException e) {
            return null;
        }
    }

    public void deleteUserReview(String name, String score, String client_name) {
        String sql = "DELETE FROM client_review where client_name = ? and book_name = ?;";
        String updateSql = "UPDATE book_raiting SET number_of_reviews = ?, mark = ? Where name = ?;";
        List<BookRaiting> bookRaitings = new BookRaitingDao().getinfo();
        for (int o = 0; o < bookRaitings.size(); o++) {
            if (bookRaitings.get(o).getName().equals(name)) {
                double raiting = 0;
                int number = 0;
                for (int i = 0; i < bookRaitings.size(); i++) {
                    if (bookRaitings.get(i).getName().equals(name)) {
                        raiting = Double.parseDouble(bookRaitings.get(i).getMark());
                        number = bookRaitings.get(i).getNumberOfReviews();
                    }
                }
                if(number == 1){
                    number = 0;
                    raiting = 0;
                }else {

                    raiting = (raiting * number - Integer.parseInt(score)) / (number - 1);
                    number -= 1;
                }
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, client_name);
                    preparedStatement.setString(2, name);
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
        }
    }
}
