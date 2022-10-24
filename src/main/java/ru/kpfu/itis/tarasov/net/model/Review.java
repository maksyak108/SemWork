package ru.kpfu.itis.tarasov.net.model;

public class Review {
    private int id;
    private String book_name;
    private String review;
    private int score;
    private String client_name;


    public Review(int id, String book_name, String review, String description, int score, String client_name) {
        this.id = id;
        this.book_name = book_name;
        this.review = review;
        this.score = score;
        this.client_name = client_name;
    }

    public Review(int id, String book_name, String review, int score, String client_name) {
        this.book_name = book_name;
        this.review = review;
        this.score = score;
        this.client_name = client_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }
}
