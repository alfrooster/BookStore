package com.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.BookStore.domain.Book;
import com.BookStore.domain.BookRepository;
import com.BookStore.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository brepository;
	
	@Test
	public void findByTitleShouldReturnAuthor() {
		List <Book> books = brepository.findByTitle("Veden alla");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Kat Falls");
	}
	
	@Test
	public void createNewBook() {
		Book book = new Book("Mickey", "Mouse", "1928", "2837569826", 18, new Category("Lastenkirjat"));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
    public void deleteOneBook() {
		List<Book> books = brepository.findByTitle("Veden alla");
		Book book = books.get(0);
		brepository.delete(book);
		List<Book> newBooks = brepository.findByTitle("Veden alla");
		assertThat(newBooks).hasSize(0);
    }

}
