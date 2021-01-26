package com.eni.filmotheque.models;

public class Avis {
	private long idAvis;
	private String libelle;
	private Film film;
	private Membre membre;
	
	public Avis() {
	}

	public long getIdAvis() {
		return idAvis;
	}

	public void setIdAvis(long idAvis) {
		this.idAvis = idAvis;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	@Override
	public String toString() {
		return "Avis [idAvis=" + idAvis + ", libelle=" + libelle + ", film=" + film + ", membre=" + membre + "]";
	}
}
