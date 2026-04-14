package com.jfa.library_api;

import com.jfa.library_api.service.BookService;
import com.jfa.library_api.entity.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApiApplication.class, args);
	}

	@Bean
	CommandLineRunner init(BookService bookService) {
		return args -> {
			bookService.addBook(new Book(null, "Clean Code", "Robert C. Martin", 2008));
			bookService.addBook(new Book(null, "Effective Java", "Joshua Bloch", 2018));
		};
	}

}
