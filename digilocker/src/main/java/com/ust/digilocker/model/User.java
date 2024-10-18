package com.ust.digilocker.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue
	private long userid;
	private String username;
	private int age;
	private long  phone_no;
	
	 @OneToMany(mappedBy = "user", fetch= FetchType.LAZY,cascade = CascadeType.ALL)
	 @JsonManagedReference
	    private List<Govdoc> govdocs;

	    @OneToMany(mappedBy = "user",fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<Certificate> certificates;

	    @OneToMany(mappedBy = "user",fetch= FetchType.LAZY, cascade = CascadeType.ALL)
	    @JsonManagedReference
	    private List<Bankdetails> bankdetails;
	

}
