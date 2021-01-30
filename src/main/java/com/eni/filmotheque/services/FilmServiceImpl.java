package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Categorie;
import com.eni.filmotheque.models.Film;
import com.eni.filmotheque.models.Participant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {
    private List<Film> films = new ArrayList();

    public FilmServiceImpl() {
        //Création des réalisateurs
        Participant realisateur1 = new Participant(1L, "Lucas", "Georges");
        Participant realisateur2 = new Participant(2L, "Tarantino", "Quentin");
        Participant realisateur3 = new Participant(3L, "Spielberg", "Steven");

        //Création des acteurs
        Participant acteur1 = new Participant(4L, "Ford", "Harrison");
        Participant acteur2 = new Participant(5L, "Thurman", "Uma");
        Participant acteur3 = new Participant(6L, "Neill", "Sam");

        //Création des categories
        Categorie categorie1 = new Categorie(1L, "Science-fiction");
        Categorie categorie2 = new Categorie(2L, "Action");
        Categorie categorie3 = new Categorie(3L, "Comédie");

        //Création des films
        Film film1 = new Film();
        film1.setIdFilm(1L);
        film1.setCategorie(categorie1);
        film1.setTitre("La guerre des étoiles");
        film1.setRealisateur(realisateur1);
        List<Participant> listFilm1 = new ArrayList();
        listFilm1.add(acteur1);
        film1.setActeurs(listFilm1);
        film1.setAnnee(1977);

        Film film2 = new Film();
        film2.setIdFilm(2L);
        film2.setCategorie(categorie2);
        film2.setTitre("Kill Bill volume 1");
        film2.setRealisateur(realisateur2);
        List<Participant> listFilm2 = new ArrayList();
        listFilm2.add(acteur2);
        film2.setActeurs(listFilm2);
        film2.setAnnee(2003);

        Film film3 = new Film();
        film3.setIdFilm(3L);
        film3.setCategorie(categorie1);
        film3.setTitre("Jurassic Park");
        film3.setRealisateur(realisateur3);
        List<Participant> listFilm3 = new ArrayList();
        listFilm3.add(acteur3);
        film3.setActeurs(listFilm3);
        film3.setAnnee(1993);

        films.add(film1);
        films.add(film2);
        films.add(film3);
    }

    @Override
    public List<Film> getListFilm() {
        return films;
    }

    @Override
    public Film getFilmById(long id) {
        Film film = new Film();
        for(Film test: films) {
            if(test.getIdFilm() == id) {
                film = test;
            }
        }
        return film;
    }

    @Override
    public void addFilm(Film film) {
        films.add(film);
    }

    @Override
    public void updateFilm(Film film) {
        for (Film unFilm: films){
            if (unFilm.getIdFilm() == film.getIdFilm()){
                unFilm.setTitre(film.getTitre());
                unFilm.setAnnee(film.getAnnee());
                unFilm.setActeurs(film.getActeurs());
                unFilm.setRealisateur(film.getRealisateur());
                unFilm.setCategorie(film.getCategorie());
            }
        }
    }

    @Override
    public void deleteFilm(Film film) {
        films.remove(film);
    }

}
