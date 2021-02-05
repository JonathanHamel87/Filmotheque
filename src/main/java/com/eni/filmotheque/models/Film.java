package com.eni.filmotheque.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFilm;

    private String titre;

    private int annee;

    @ManyToOne
    @JoinColumn(name = "idRealisateur", nullable = false)
    private Participant realisateur;

    @ManyToMany
    @JoinTable(
            name = "acteurs_films",
            joinColumns = @JoinColumn(name = "idFilm"),
            inverseJoinColumns = @JoinColumn(name = "idParticipant")
    )
    private List<Participant> acteurs;

    @ManyToOne
    @JoinColumn(name = "idCategorie", nullable = false)
    private Categorie categorie;

    @OneToMany(mappedBy = "film")
    private List<Avis> avis;

}
