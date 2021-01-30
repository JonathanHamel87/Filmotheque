package com.eni.filmotheque.forms;

import java.util.List;

public class FilmForm {
    private long idFilm;
    private String titre;
    private Integer annee;
    private Long idRealisateur;
    private List<Long> idActeurs;
    private Long idCategorie;

    public FilmForm() {
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

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public Long getIdRealisateur() {
        return idRealisateur;
    }

    public void setIdRealisateur(Long idRealisateur) {
        this.idRealisateur = idRealisateur;
    }

    public List<Long> getIdActeurs() {
        return idActeurs;
    }

    public void setIdActeurs(List<Long> idActeurs) {
        this.idActeurs = idActeurs;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Override
    public String toString() {
        return "FilmForm{" +
                "idFilm=" + idFilm +
                ", titre='" + titre + '\'' +
                ", annee=" + annee +
                ", idRealisateur=" + idRealisateur +
                ", idActeurs=" + idActeurs +
                ", idCategorie=" + idCategorie +
                '}';
    }
}
