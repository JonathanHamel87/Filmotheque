package com.eni.filmotheque.models;

import java.util.List;

public class Participant {
	private long idParticipant;
	private String nom;
	private String prenom;
	private List<Film> listeFilmRealise;
	private List<Film> listeFilmJoue;
	
	public Participant() {
	}

	public Participant(long idParticipant, String nom, String prenom) {
		this.idParticipant = idParticipant;
		this.nom = nom;
		this.prenom = prenom;
	}

	public long getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(long idParticipant) {
		this.idParticipant = idParticipant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Film> getListeFilmRealise() {
		return listeFilmRealise;
	}

	public void setListeFilmRealise(List<Film> listeFilmRealise) {
		this.listeFilmRealise = listeFilmRealise;
	}

	public List<Film> getListeFilmJoue() {
		return listeFilmJoue;
	}

	public void setListeFilmJoue(List<Film> listeFilmJoue) {
		this.listeFilmJoue = listeFilmJoue;
	}

	@Override
	public String toString() {
		return "Participant [idParticipant=" + idParticipant + ", nom=" + nom + ", prenom=" + prenom
				+ ", listeFilmRealise=" + listeFilmRealise + ", listeFilmJoue=" + listeFilmJoue + "]";
	}

	
}
