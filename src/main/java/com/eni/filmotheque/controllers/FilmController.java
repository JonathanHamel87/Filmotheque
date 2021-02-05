package com.eni.filmotheque.controllers;

import com.eni.filmotheque.forms.FilmForm;
import com.eni.filmotheque.models.Categorie;
import com.eni.filmotheque.models.Film;
import com.eni.filmotheque.models.Participant;
import com.eni.filmotheque.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmController {
    private FilmService filmService;
    private ParticipantService participantService;
    private CategorieService categorieService;

    public FilmController(FilmService filmService, ParticipantService participantService, CategorieService categorieService) {
        this.filmService = filmService;
        this.participantService = participantService;
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
        model.addAttribute("acteurs", participantService.getListParticipant());
        model.addAttribute("realisateurs", participantService.getListParticipant());
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
        newFilm.setRealisateur(participantService.getParticipantById(film.getIdRealisateur()));
        newFilm.setActeurs(participantService.getListParticipantsByListId(film.getIdActeurs()));

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

        model.addAttribute("acteurs", participantService.getListParticipant());
        model.addAttribute("realisateurs", participantService.getListParticipant());
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
        newFilm.setRealisateur(participantService.getParticipantById(film.getIdRealisateur()));
        newFilm.setActeurs(participantService.getListParticipantsByListId(film.getIdActeurs()));

        filmService.updateFilm(newFilm);

        return "redirect:/";
    }

    @GetMapping("supprimeFilm/{id}")
    public String delFilm(@PathVariable long id){
        filmService.deleteFilm(filmService.getFilmById(id));
        return "redirect:/";
    }

    @GetMapping("/showPopup/{classe}")
    public String showPopup(@PathVariable String classe){
        return "modals/add"+classe;
    }

    @PostMapping("/addCategorie")
    @ResponseBody
    public List<Categorie> addCategorie(@RequestParam String label){
        if (categorieService.getCategorieByLabel(label).getIdCategorie() == 0){
            Categorie categ = new Categorie();
            categ.setLabel(label);
            categorieService.addCategorie(categ);
        }
        return categorieService.getListCategories();
    }

    @PostMapping("/addParticipant")
    @ResponseStatus(HttpStatus.OK)
    public void addParticipant(@RequestParam String nom, @RequestParam String prenom){
        if (participantService.getParticipantByNomPrenom(nom, prenom).getIdParticipant() == 0){
            Participant participant = new Participant();
            participant.setNom(nom);
            participant.setPrenom(prenom);
            participant.setListeFilmJoue(new ArrayList<>());
            participant.setListeFilmRealise(new ArrayList<>());
            participantService.addParticipant(participant);
        }
    }
}
