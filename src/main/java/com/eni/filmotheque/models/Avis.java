package com.eni.filmotheque.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Avis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAvis;

	private String libelle;

	@ManyToOne
	@JoinColumn(name = "idFilm", nullable = false)
	private Film film;

	@ManyToOne
	@JoinColumn(name = "idMembre", nullable = false)
	private Membre membre;

}
