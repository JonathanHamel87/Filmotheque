package com.eni.filmotheque.controllers;

import com.eni.filmotheque.forms.FilmForm;
import com.eni.filmotheque.models.Categorie;
import com.eni.filmotheque.models.Film;
import com.eni.filmotheque.models.Participant;
import com.eni.filmotheque.services.ActeurService;
import com.eni.filmotheque.services.CategorieService;
import com.eni.filmotheque.services.FilmService;
import com.eni.filmotheque.services.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmController {
    private FilmService filmService;
    private ActeurService acteurService;
    private RealisateurService realisateurService;
    private CategorieService categorieService;

    public FilmController(FilmService filmService, ActeurService acteurService, RealisateurService realisateurService, CategorieService categorieService) {
        this.filmService = filmService;
        this.acteurService = acteurService;
        this.realisateurService = realisateurService;
        this.categorieService = categorieService;
    }

    @GetMapping("")
    public String afficherListeFilm(Model model) {

        model.addAttribute("films", filmService.getListFilm());

        return "listeFilm";
    }

    @GetMapping("/detail/{id}")
    public String afficheDetailFilm(@PathVariable long id, Model model) {
        Film film = filmService.getFilmById(id);
        model.addAttribute("film", film);

        return "detailFilm";
    }

    @GetMapping("/ajouterFilm")
    public String ajouterFilmView(Model model) {
        model.addAttribute("acteurs", acteurService.getListActeurs());
        model.addAttribute("realisateurs", realisateurService.getListRealisateur());
        model.addAttribute("categories", categorieService.getListCategories());
        model.addAttribute("film", new FilmForm());

        return "addFilm";
    }


    @PostMapping("/ajouterFilm")
    public String ajouterFilm(@ModelAttribute("film") FilmForm film) {

        Film newFilm = new Film();
        newFilm.setTitre(film.getTitre());
        newFilm.setAnnee(film.getAnnee());
        newFilm.setCategorie(categorieService.getCategorieById(film.getIdCategorie()));
        newFilm.setRealisateur(realisateurService.getRealisateurById(film.getIdRealisateur()));
        newFilm.setActeurs(acteurService.getListActeursByListId(film.getIdActeurs()));

        filmService.addFilm(newFilm);

        return "redirect:/";
    }

    @GetMapping("/modifierFilm/{id}")
    public String modifierFilmView(@PathVariable long id, Model model){
        Film film = filmService.getFilmById(id);
        FilmForm filmForm = new FilmForm();

        List<Long> idActeurs = new ArrayList<>();
        for (Participant acteur: film.getActeurs()){
            idActeurs.add(acteur.getIdParticipant());
        }

        filmForm.setIdFilm(film.getIdFilm());
        filmForm.setTitre(film.getTitre());
        filmForm.setAnnee(film.getAnnee());
        filmForm.setIdCategorie(film.getCategorie().getIdCategorie());
        filmForm.setIdRealisateur(film.getRealisateur().getIdParticipant());
        filmForm.setIdActeurs(idActeurs);

        model.addAttribute("acteurs", acteurService.getListActeurs());
        model.addAttribute("realisateurs", realisateurService.getListRealisateur());
        model.addAttribute("categories", categorieService.getListCategories());
        model.addAttribute("film", filmForm);

        return "updateFilm";
    }

    @PostMapping("/modifierFilm")
    public String updateFilm(@ModelAttribute("film") FilmForm film) {
        Film newFilm = new Film();

        newFilm.setIdFilm(film.getIdFilm());
        newFilm.setTitre(film.getTitre());
        newFilm.setAnnee(film.getAnnee());
        newFilm.setCategorie(categorieService.getCategorieById(film.getIdCategorie()));
        newFilm.setRealisateur(realisateurService.getRealisateurById(film.getIdRealisateur()));
        newFilm.setActeurs(acteurService.getListActeursByListId(film.getIdActeurs()));

        filmService.updateFilm(newFilm);

        return "redirect:/";
    }

    @GetMapping("supprimeFilm/{id}")
    public String delFilm(@PathVariable long id){
        filmService.deleteFilm(filmService.getFilmById(id));
        return "redirect:/";
    }
}
