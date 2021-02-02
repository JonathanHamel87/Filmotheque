package com.eni.filmotheque.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCategorie;

	private String label;

}
