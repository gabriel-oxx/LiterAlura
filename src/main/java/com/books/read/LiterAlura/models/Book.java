package com.books.read.LiterAlura.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String title;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    @Transient
    private List<AuthorData> authors;
    private List<String> languages;
    private String language;
    Integer downloadCount;


    public Book(BookData bookData) {
        this.title = bookData.title();
        this.id = bookData.id();
        this.languages = bookData.languages();
        this.language = languages.get(0);
        this.downloadCount = bookData.downloadCount();
/*
        List<Author> allAuthors = bookData.authors().stream()
                .map(authorData -> new Author(authorData))
                .collect(Collectors.toList());
        this.authors = allAuthors.size() > 0? allAuthors.subList(0, 1) : Collections.emptyList(); // Mantém apenas o primeiro autor, se houver
    this.author = allAuthors.get(0);
    */
        AuthorData data = bookData.authors().get(0);
        this.author = new Author(data);
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /*
        public static List<Author> convertFirstAuthorDataToAuthor(List<AuthorData> authorDataList) {
            if (authorDataList == null || authorDataList.isEmpty()) {
                return Collections.emptyList();
            }
            List<Author> authors = new ArrayList<>();
            AuthorData firstAuthorData = authorDataList.get(0);
            authors.add(new Author(firstAuthorData));
            return authors;
        }
    */
    @Override
    public String toString() {
        return "Título: " + title + ", " + " autor: " + author.getName() + ", idioma: " + language + ", baixado " + downloadCount + " vezes";
    }


}