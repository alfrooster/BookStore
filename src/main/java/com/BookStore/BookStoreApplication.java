package com.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.BookStore.domain.Book;
import com.BookStore.domain.BookRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository){
		return (args) -> {
			
			repository.save(new Book("Veden alla", "Kat Falls", "2011", "9513155064", 9));
			repository.save(new Book("Klik", "Tap", "2007", "23434", 7));
		};
	}


}
