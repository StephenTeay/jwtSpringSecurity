package com.teay.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teay.security.models.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {
    Books findByBookTitle(String bookTitle);
}
