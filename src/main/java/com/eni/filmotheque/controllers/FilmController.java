package com.eni.filmotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eni.filmotheque.models.Film;
import com.eni.filmotheque.services.FilmService;

@Controller
@RequestMapping("films")
public class FilmController {
	@Autowired
	private FilmService filmService;
	
	@GetMapping("")
	public String afficherListeFilm(Model model) {
		
		model.addAttribute("films", filmService.getListFilm().size());
		
		return "listeFilm";
	}
	
	@GetMapping("/detail/{id}")
	public String afficheDetailFilm(@PathVariable long id, Model model) {
		Film film = filmService.getFilmById(id);
		return "detailFilm";
	}
}
