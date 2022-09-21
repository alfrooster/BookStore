package com.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.BookStore.domain.Book;
import com.BookStore.domain.BookRepository;
import com.BookStore.domain.Category;
import com.BookStore.domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository){
		return (args) -> {

			crepository.save(new Category("Kauhu"));
			crepository.save(new Category("Jännitys"));
			crepository.save(new Category("Historia"));
			crepository.save(new Category("Romanssi"));
			crepository.save(new Category("Mysteeri"));
			
			repository.save(new Book("Veden alla", "Kat Falls", "2011", "9513155064", 9, crepository.findByName("Jännitys").get(0)));
			repository.save(new Book("Klik", "Tap", "2007", "23434", 7, crepository.findByName("Romanssi").get(0)));
			
		};
	}

}
