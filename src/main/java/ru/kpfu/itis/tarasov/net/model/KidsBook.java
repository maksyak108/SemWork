package ru.kpfu.itis.tarasov.net.model;

public class KidsBook {
    private int id;
    private String author;
    private String name;
    private String description;


    public KidsBook(int id, String author, String name, String description, String string) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.description = description;
    }

    public KidsBook(int id, String author, String name, String description) {
        this.author = author;
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

