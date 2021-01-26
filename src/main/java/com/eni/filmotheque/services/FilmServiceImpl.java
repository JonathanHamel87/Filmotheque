package com.eni.filmotheque.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eni.filmotheque.models.Film;

@Service
public class FilmServiceImpl implements FilmService{
	private List<Film> films = new ArrayList();
	
	public FilmServiceImpl() {
		Film film1 = new Film();
		Film film2 = new Film();
		Film film3 = new Film();
		
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
	
}
