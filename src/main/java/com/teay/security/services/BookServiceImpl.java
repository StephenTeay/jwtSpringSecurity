package com.teay.security.services;

import com.teay.security.dtos.BookRequest;
import com.teay.security.models.Books;
import com.teay.security.repositories.BookRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;

    }
    @Override
    public Books addBook(BookRequest request) {
        Books newBook = new Books();
        if(bookRepository.findByBookTitle(request.getBookTitle()) != null) {
            Books updateBook = bookRepository.findByBookTitle(request.getBookTitle());
            updateBook.setBookCount(updateBook.getBookCount() + request.getBookCount());
            updateBook.setBookAvailableCount(updateBook.getBookCount());
            return bookRepository.save(updateBook);
        }
        else{
            newBook.setBookTitle(request.getBookTitle());
            newBook.setBookAuthors(request.getAuthors());
            newBook.setBookCount(request.getBookCount());
            newBook.setBookAvailable(true);
            newBook.setBookAvailableCount(request.getBookCount());
            return bookRepository.save(newBook);

        }
    }

    @Override
    public void deleteBook(String bookName) {
        Optional<Books> book = Optional.ofNullable(bookRepository.findByBookTitle(bookName));
        if(book.isPresent()){
            Long bookId = book.get().getBookId();
            bookRepository.deleteById(bookId);
        }
        else{
            throw new RuntimeException("Book doesn't exist "); //To fix with global Exc
        }

    }

    @Override
    public Books getBook(String bookName) {
        return bookRepository.findByBookTitle(bookName);
    }

    @Override
    public Books getBook(Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(()->new RuntimeException("Book exist not"));
    }
}
