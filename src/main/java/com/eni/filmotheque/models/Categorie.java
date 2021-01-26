package com.eni.filmotheque.models;


public class Categorie {
	private long idCategorie;
	private String label;
	
	public Categorie() {
	}
	
	
	
	public long getIdCategorie() {
		return idCategorie;
	}



	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}



	public String getLabel() {
		return label;
	}



	public void setLabel(String label) {
		this.label = label;
	}



	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", label=" + label + "]";
	}
}
