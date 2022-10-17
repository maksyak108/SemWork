package ru.kpfu.itis.tarasov.net.model;

public class BookRaiting {
    private int id;
    private int bookId;
    private int numberOfReviews;
    private String mark;


    public BookRaiting(int id, int bookId, int numberOfReviews, String mark) {
        this.id = id;
        this.bookId = bookId;
        this.numberOfReviews = numberOfReviews;
        this.mark = mark;
    }

    public BookRaiting(int bookId, int numberOfReviews, String mark) {
        this.bookId = bookId;
        this.numberOfReviews = numberOfReviews;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(int numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
