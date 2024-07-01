package com.books.read.LiterAlura.repositories;

import com.books.read.LiterAlura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.language = :language")
    List<Book> findByLanguage(@Param("language") String language);
}
