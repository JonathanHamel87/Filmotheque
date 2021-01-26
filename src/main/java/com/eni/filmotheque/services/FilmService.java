package com.eni.filmotheque.services;

import java.util.List;

import com.eni.filmotheque.models.Film;

public interface FilmService {
	public List<Film> getListFilm();
	
	public Film getFilmById(long id);
}
