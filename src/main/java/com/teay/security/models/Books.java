package com.teay.security.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private int bookCount;
    private int bookAvailableCount;
    private String bookTitle;
    private ArrayList<String> bookAuthors;
    private boolean isBookAvailable;

    public ArrayList<String> getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(ArrayList<String> bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookAvailableCount() {
        return bookAvailableCount;
    }

    public void setBookAvailableCount(int bookAvailableCount) {
        this.bookAvailableCount = bookAvailableCount;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public boolean isBookAvailable() {
        return isBookAvailable;
    }

    public void setBookAvailable(boolean bookAvailable) {
        isBookAvailable = bookAvailable;
    }
}
