package com.ust.digilocker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Bankdetails {
	@Id
	@GeneratedValue
	private long bankid;
	private String bankname;
	private long accno;
	private String ifscode;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonBackReference
    private User user;

}
