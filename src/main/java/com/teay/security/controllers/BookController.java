package com.teay.security.controllers;

import com.teay.security.dtos.BookRequest;
import com.teay.security.models.Books;
import com.teay.security.services.BookServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private final BookServiceImpl bookServiceImpl;


    public BookController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }

    @PostMapping("/book")
    public ResponseEntity<Books> createBook(@Valid @RequestBody BookRequest request) {
        return new ResponseEntity<>(bookServiceImpl.addBook(request), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/books", params = "bookName")
    public ResponseEntity<Void> deleteBook(@RequestParam String bookName) {
        bookServiceImpl.deleteBook(bookName);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getBook(@PathVariable Long id) {
        return new ResponseEntity<>(bookServiceImpl.getBook(id), HttpStatus.OK);
    }

    @GetMapping(value = "/books", params = "name")
    public ResponseEntity<Books> getBookbyName(@RequestParam String name) {
        return new ResponseEntity<>(bookServiceImpl.getBook(name), HttpStatus.OK);
    }
}
