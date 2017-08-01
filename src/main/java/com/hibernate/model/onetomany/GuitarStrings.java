package com.hibernate.model.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class GuitarStrings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stringId;
	private String material;
	
	@ManyToOne
	@JoinColumn(name = "guitar_id")
	private Guitar guitar;
	
	public GuitarStrings(){
		
	}
	
	public GuitarStrings(Long stringId, String material, Guitar guitar) {
		super();
		this.stringId = stringId;
		this.material = material;
		this.guitar = guitar;
	}
	
	public Guitar getGuitar() {
		return guitar;
	}

	public void setGuitar(Guitar guitar) {
		this.guitar = guitar;
	}

	public Long getStringId() {
		return stringId;
	}
	public void setStringId(Long stringId) {
		this.stringId = stringId;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
}
