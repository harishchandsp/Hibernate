package com.hibernate.model.manytomany;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long BookId;
	private String BookName;
	private String BookType;
	private BigDecimal price;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST }, targetEntity = Author.class)
	@JoinTable(name = "Book_Author", joinColumns = {
			@JoinColumn(name = "BookId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "AuthorId", nullable = false) })
	private List<Author> a1 = new ArrayList<>();

	public Book() {
		super();
	}

	public Book(Long bookId, String bookName, String bookType, BigDecimal price, List<Author> a1) {
		super();
		
		BookName = bookName;
		BookType = bookType;
		this.price = price;
		this.a1 = a1;
	}

	public Long getBookId() {
		return BookId;
	}

	public void setBookId(Long bookId) {
		BookId = bookId;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getBookType() {
		return BookType;
	}

	public void setBookType(String bookType) {
		BookType = bookType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Author> getA1() {
		return a1;
	}

	public void setA1(List<Author> a1) {
		this.a1 = a1;
	}

}
