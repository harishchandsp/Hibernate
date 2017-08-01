package com.hibernate.model.onetoone;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Passport implements Serializable{
	public static final long serialVersionUID=1L;
	@GenericGenerator(name="generate",strategy="foreign",parameters=@Parameter(name="property",value="person"))
	@Id
	@GeneratedValue(generator="generate")
	private Long personId;
		
	@OneToOne
	@PrimaryKeyJoinColumn
	private Person person;
	private String passportNumber;
	private LocalDate validDate;
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public LocalDate getValidDate() {
		return validDate;
	}
	public void setValidDate(LocalDate validDate) {
		this.validDate = validDate;
	}

}
