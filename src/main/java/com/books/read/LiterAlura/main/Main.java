package com.books.read.LiterAlura.main;

import com.books.read.LiterAlura.models.*;
import com.books.read.LiterAlura.repositories.AuthorRepository;
import com.books.read.LiterAlura.repositories.BookRepository;
import com.books.read.LiterAlura.service.ApiConsumption;
import com.books.read.LiterAlura.service.DataConverterIImpl;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final ApiConsumption CONSUMPTION = new ApiConsumption();
    private final Scanner INPUT = new Scanner(System.in);
    private DataConverterIImpl converterI = new DataConverterIImpl();

    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    public Main(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void displayMenu() throws URISyntaxException, IOException, InterruptedException {
        String menu = """
                1 - Buscar livro por título
                2 - Listar livros armazenados
                3 - Listar autores disponíveis
                4 - Listar autores vivos em um determinado ano
                5 - Exibir a quantidade de livros disponíveis em algum idioma escolhido por você
                0 - Sair
                """;
        int option = -1;

        do {

            try {

                System.out.println("Escolha uma das seguintes opções:\n" + menu);
                option = INPUT.nextInt();
                INPUT.nextLine();
            } catch (InputMismatchException error) {
                System.err.println("Só são permitidos valores inteiros aqui. " + error.getMessage());
            }

            switch (option) {
                case 1:
                    searchBook();
                    break;
                case 2:
                    listBooks();
                    break;
                case 3:
                    listAuthors();
                    break;
                case 4:
                    listAliveAuthors();
                    break;
                case 5:
                    listBooksByLanguage();
                    break;
                case 0:
                    System.out.println("Saindo... Até a próxima!");
                    break;
                default:
                    System.out.println("Essa opção não existe");
                    break;
            }


        } while (option != 0);

    }

    private void searchBook() throws URISyntaxException, IOException, InterruptedException {
        System.out.println("Insira o nome de um autor ou de um livro, e eu verei o que posso encontrar");
        String text = INPUT.nextLine();

        String json = CONSUMPTION.consumption(text);
        Results books = converterI.getData(json, Results.class);

        if (books.results().size() > 0) {
            BookData data = books.results().get(0);
            try {
                Book book = new Book(data);
                System.out.println(book);
                bookRepository.save(book);
            } catch (NullPointerException error) {
                System.err.println("Opa, houve um erro aqui." + error.getMessage());
            }
        } else
            System.out.println("Nenhum elemento encontrado com este(s) termo(s)");
    }

    private void listBooks() {
        System.out.println("Esses são os livros armazenados:");
        bookRepository.findAll().forEach(System.out::println);
    }

    private void listAuthors() {
        System.out.println("Esses são os autores disponíveis:");
        authorRepository.findAll().forEach(System.out::println);
    }


    private void listBooksByLanguage() {
        System.out.println("Qual idioma você deseja pesquisar?");
        String language = INPUT.nextLine();
        List<Book> books = bookRepository.findByLanguage(language);
        Long sum = books.stream().count();
        if (sum > 0) {

            if (sum == 1)
                System.out.printf("Há %d livro escrito em %s%n", sum, language);
            else
                System.out.printf("Há %d livros escritos em %s%n", sum, language);
        } else
            System.out.println("No momento não há nenhum livro disponível nesse idioma");
    }

    private void  listAliveAuthors() {
        System.out.println("Insira o valor correspondente a um ano e eu verei se havia algum autor vivo nesse ano");
        Long value = INPUT.nextLong();
        List<Author> authors = authorRepository.findAuthorByYear(value);
        if (authors.size() > 0) {
            System.out.println("Aqui está:");
            authors.forEach(System.out::println);
        }
        else
            System.out.println("Não encontrei no meu sistema registro de nenhum autor vivo nesse ano");
    }
}

