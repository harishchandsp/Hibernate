package com.hibernate.model.manytomany;

import java.time.LocalDate;
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


import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long AuthorId;

	@NotBlank(message = "first name can not be blank")
	private String fName;

	@NotBlank(message = "last name can not be blank")
	private String lName;

	// @NotNull(message = "date of birth can not be blank")
	private LocalDate dob;

	private String phoneNumber;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST }, targetEntity = Book.class)
	@JoinTable(name = "Book_Author", joinColumns = {
			@JoinColumn(name = "AuthorId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "BookId", nullable = false) })
	private List<Book> book = new ArrayList<>();

	public Author() {
		super();
	}

	public Author(Long authorId, String fName, String lName, LocalDate dob, String phoneNumber, List<Book> book) {
		super();
		
		this.fName = fName;
		this.lName = lName;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.book = book;
	}

	public Long getAuthorId() {
		return AuthorId;
	}

	public void setAuthorId(Long authorId) {
		AuthorId = authorId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	
}
