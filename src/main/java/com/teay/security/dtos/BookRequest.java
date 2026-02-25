package com.teay.security.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

public class BookRequest {
    @NotNull(message = "Everybook must have a title")
    private String bookTitle;

    @NotNull(message = "A book must have at least one author")
    private ArrayList<String> authors;

    @Min(value = 1, message = "You can't add a book you don't have")
    private int bookCount;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }
}
