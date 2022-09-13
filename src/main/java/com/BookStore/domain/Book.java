package com.BookStore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String author;
	private String pubyear;
	private String isbn;
	private Integer price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPubyear() {
		return pubyear;
	}
	public void setPubyear(String pubyear) {
		this.pubyear = pubyear;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public Book() {}
	
	public Book(String title, String author, String pubyear, String isbn, Integer price) {
		super();
		this.title = title;
		this.author = author;
		this.pubyear = pubyear;
		this.isbn = isbn;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book id=" + id + ", title=" + title + ", author=" + author + ", year=" + pubyear + ", isbn=" + isbn
				+ ", price=" + price;
	}
	
}
