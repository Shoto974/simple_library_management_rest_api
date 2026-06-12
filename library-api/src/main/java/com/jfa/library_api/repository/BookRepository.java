package com.jfa.library_api.repository;

import com.jfa.library_api.entity.Book;
import com.jfa.library_api.exceptions.BookNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BookRepository {
    private final Map<Long, Book> books = new HashMap<>();

    public void save(Book book) {
        this.books.put(book.id(), book);
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(this.books.get(id));
    }

    public List<Book> findAll() {
        return new ArrayList<>(this.books.values());
    }

    public void deleteById(Long id) {
        this.books.remove(id);
    }
}
