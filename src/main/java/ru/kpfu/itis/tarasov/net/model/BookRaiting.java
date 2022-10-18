package ru.kpfu.itis.tarasov.net.model;

public class BookRaiting {
    private int id;
    private int bookId;
    private int numberOfReviews;
    private String mark;
    private String name;


    public BookRaiting(int id, int bookId, int numberOfReviews, String mark, String name) {
        this.id = id;
        this.bookId = bookId;
        this.numberOfReviews = numberOfReviews;
        this.mark = mark;
        this.name = name;
    }

    public BookRaiting(int bookId, int numberOfReviews, String mark, String name) {
        this.bookId = bookId;
        this.numberOfReviews = numberOfReviews;
        this.mark = mark;
        this.name = name;
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

    public void setMark(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
