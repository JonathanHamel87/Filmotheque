package com.eni.filmotheque.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idParticipant;

	private String nom;

	private String prenom;

	@OneToMany(mappedBy = "realisateur")
	private List<Film> listeFilmRealise;

	@ManyToMany(mappedBy = "acteurs")
	private List<Film> listeFilmJoue;

}
