package com.teay.security.services;

import com.teay.security.dtos.BookRequest;
import com.teay.security.models.Books;

public interface BookService {
    Books addBook(BookRequest request);
    void deleteBook(String bookName);
    Books getBook(String bookName);
    Books getBook(Long bookId);
}
