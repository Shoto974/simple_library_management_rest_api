package com.jfa.library_api.service;

import com.jfa.library_api.repository.BookRepository;
import com.jfa.library_api.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AtomicLong counter = new AtomicLong();


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(long id){
        return bookRepository.findById(id).get();
    }

    public Book addBook(Book book){
        Long id = counter.incrementAndGet();
        Book newBook = new Book(id, book.title(), book.author(), book.year());
        bookRepository.save(newBook);
        return newBook;
    }

    public Book updateBook(Long id, Book book) {
        Book updatedBook = new Book(id, book.title(), book.author(), book.year());
        bookRepository.save(updatedBook);
        return updatedBook;
    }

    public void deleteBook(long id){
        bookRepository.deleteById(id);
    }

}
