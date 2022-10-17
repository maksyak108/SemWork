package ru.kpfu.itis.tarasov.net.model;

public class Book {
    private int id;
    private String author;
    private String name;
    private String ganre;
    private String description;


    public Book(int id, String author, String name, String ganre, String description, String string) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.ganre = ganre;
        this.description = description;
    }

    public Book(int id, String author, String name, String ganre, String description) {
        this.author = author;
        this.name = name;
        this.ganre = ganre;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGanre() {
        return ganre;
    }

    public void setGanre(String ganre) {
        this.ganre = ganre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
