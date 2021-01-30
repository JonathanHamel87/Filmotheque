package com.eni.filmotheque.models;

import java.util.List;

public class Film {
    private long idFilm;
    private String titre;
    private int annee;
    private Participant realisateur;
    private List<Participant> acteurs;
    private Categorie categorie;
    private List<Avis> avis;

    public Film() {
    }

    public long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(long idFilm) {
        this.idFilm = idFilm;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Participant getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Participant realisateur) {
        this.realisateur = realisateur;
    }

    public List<Participant> getActeurs() {
        return acteurs;
    }

    public void setActeurs(List<Participant> acteurs) {
        this.acteurs = acteurs;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Avis> getAvis() {
        return avis;
    }

    public void setAvis(List<Avis> avis) {
        this.avis = avis;
    }

    @Override
    public String toString() {
        return "Film [idFilm=" + idFilm + ", titre=" + titre + ", annee=" + annee + ", realisateur=" + realisateur
                + ", acteurs=" + acteurs + ", categorie=" + categorie + ", avis=" + avis + "]";
    }


}
