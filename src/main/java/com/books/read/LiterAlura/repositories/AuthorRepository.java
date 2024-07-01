package com.books.read.LiterAlura.repositories;

import com.books.read.LiterAlura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE (a.birthYear <= :y AND (a.deathYear IS NULL OR a.deathYear > :y))")
    List<Author> findAuthorByYear(@Param("y") Long year);
}

