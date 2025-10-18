package org.example.UP1.Tareas.Tarea5;

import java.io.Serializable;

public class Book implements Serializable {

    private String author;
    private String name;
    private String editorial;
    private String date;

    public Book(String author, String name, String editorial, String date) {
        this.author = author;
        this.name = name;
        this.editorial = editorial;
        this.date = date;
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

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", editorial='" + editorial + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
