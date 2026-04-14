package com.jfa.library_api.service;


import com.jfa.library_api.entity.Book;
import com.jfa.library_api.repository.BookRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    private BookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository();
        bookService = new BookService(bookRepository);

        // On initialise des données
        bookService.addBook(new Book(null, "Spring in Action", "Craig Walls", 2022));
        bookService.addBook(new Book(null, "Refactoring", "Martin Fowler", 2019));
        bookService.addBook(new Book(null, "The Pragmatic Programmer", "Andrew Hunt", 1999));
    }

    @Test
    void getAllBooks() {
        var books = bookService.getAllBooks();

        assertNotNull(books);
        assertEquals(3, books.size());
    }

    @Test
    void getBookById() {
        var book = bookService.getBookById(3L);
        assertNotNull(book);
        assertEquals("The Pragmatic Programmer", book.title());
    }

    @Test
    void addBook() {
        var book = new Book(null, "New book", "Craig Walls", 2022);
        bookService.addBook(book);
        assertEquals(4, bookService.getAllBooks().size());
        assertEquals("New book", bookService.getBookById(4).title());
    }

    @Test
    void updateBook() {
        Book book = new Book(null, "Updated Spring in Action", "Craig Walls", 2026);
        bookService.updateBook(1L, book);
        assertEquals(book.title(), bookService.getBookById(1L).title());
        assertEquals(3, bookService.getAllBooks().size());
    }

    @Test
    void deleteBook() {
        bookService.deleteBook(1L);
        assertEquals(2, bookService.getAllBooks().size());
    }
}