package com.books.read.LiterAlura;

import com.books.read.LiterAlura.main.Main;
import com.books.read.LiterAlura.repositories.AuthorRepository;
import com.books.read.LiterAlura.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;
@Autowired
private AuthorRepository authorRepository;
    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }


    @Override
    public void run(String... args) throws URISyntaxException, IOException, InterruptedException {
        Main main = new Main(bookRepository, authorRepository);
        main.displayMenu();
    }
}
