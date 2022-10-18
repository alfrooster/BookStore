package com.BookStore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.BookStore.domain.Book;
import com.BookStore.domain.BookRepository;
import com.BookStore.domain.Category;
import com.BookStore.domain.CategoryRepository;
import com.BookStore.domain.Bookuser;
import com.BookStore.domain.UserRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository){
		return (args) -> {
			
			urepository.deleteAll();
			
			crepository.save(new Category("Kauhu"));
			crepository.save(new Category("Jännitys"));
			crepository.save(new Category("Historia"));
			crepository.save(new Category("Romanssi"));
			crepository.save(new Category("Mysteeri"));
			
			repository.save(new Book("Veden alla", "Kat Falls", "2011", "9513155064", 9, crepository.findByName("Jännitys").get(0)));
			repository.save(new Book("Klik", "Tap", "2007", "23434", 7, crepository.findByName("Romanssi").get(0)));
			
			Bookuser user1 = new Bookuser("user", "$2a$10$OFn6F.J44qazXku6To04nOq1Gb3wdD2OK0dubT7nbHIsABLFc.Be.", "user@bookstore.com", "USER");
			Bookuser user2 = new Bookuser("admin", "$2a$10$1NRatnmKMeiz3ryhPrF/XuDAKeMNhSu.j6BCHiTrUEWvZC.3mF34W", "admin@bookstore.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
		};
	}

}
