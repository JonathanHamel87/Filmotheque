package com.eni.filmotheque.models;

import java.util.List;

public class Membre {
	private long idMembre;
	private String nom;
	private String prenom;
	private boolean isAdmin;
	private List<Avis> listAvis;
	
	public Membre() {
	}

	public long getIdMembre() {
		return idMembre;
	}

	public void setIdMembre(long idMembre) {
		this.idMembre = idMembre;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<Avis> getListAvis() {
		return listAvis;
	}

	public void setListAvis(List<Avis> listAvis) {
		this.listAvis = listAvis;
	}

	@Override
	public String toString() {
		return "Membre [idMembre=" + idMembre + ", nom=" + nom + ", prenom=" + prenom + ", isAdmin=" + isAdmin
				+ ", listAvis=" + listAvis + "]";
	}

}
