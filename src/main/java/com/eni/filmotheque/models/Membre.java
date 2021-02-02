package com.eni.filmotheque.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @ToString
public class Membre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMembre;
	private String nom;
	private String prenom;
	private boolean isAdmin;

	@OneToMany(mappedBy = "membre")
	private List<Avis> listAvis;

}
