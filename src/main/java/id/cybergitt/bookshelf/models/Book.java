/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.cybergitt.bookshelf.models;

import java.util.Objects;

/**
 *
 * @author khazefa
 */
public class Book {
    private String title;
    private String author;

    public Book() {
    }

    public Book(String title, String author) {
        this.title = Objects.requireNonNull(title).trim();
        if (this.isBlank(title)){
            throw new IllegalArgumentException("Title is empty.");
        }
        this.author = Objects.requireNonNull(author).trim();
        if (this.isBlank(author)){
            throw new IllegalArgumentException("Author is empty.");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format(
            "Book{title='%s' \t\t author=%s}",
            title, author);
    }
    
    private boolean isBlank(String text) {
        return text == null || text.trim().length() == 0;
    }
}
