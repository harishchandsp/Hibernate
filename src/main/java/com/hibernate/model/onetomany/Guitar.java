package com.hibernate.model.onetomany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;



@Entity
public class Guitar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guitarId;
	private String guitarName;
	
			
	@OneToMany(mappedBy = "guitar", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	// @OrderColumn(name="idx")
	@OrderColumn
	//@Fetch(FetchMode.JOIN) // JOIN(one query to get both course and topic),SELECT(two queries to get course and topic)
	private List<GuitarStrings> guitarStrings = new ArrayList<>();

	public Guitar() {

	}

	
	public Guitar(Long guitarId, String guitarName, List<GuitarStrings> guitarStrings) {
		super();
		this.guitarId = guitarId;
		this.guitarName = guitarName;
		this.guitarStrings = guitarStrings;
	}


	public Long getGuitarId() {
		return guitarId;
	}


	public void setGuitarId(Long guitarId) {
		this.guitarId = guitarId;
	}


	public String getGuitarName() {
		return guitarName;
	}


	public void setGuitarName(String guitarName) {
		this.guitarName = guitarName;
	}


	public List<GuitarStrings> getGuitarStrings() {
		return guitarStrings;
	}


	public void setGuitarStrings(List<GuitarStrings> guitarStrings) {
		this.guitarStrings = guitarStrings;
	}

	

}
