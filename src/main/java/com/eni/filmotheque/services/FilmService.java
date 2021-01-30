package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Film;

import java.util.List;

public interface FilmService {
    public List<Film> getListFilm();

    public Film getFilmById(long id);

    public void addFilm(Film film);

    public void updateFilm(Film film);

    public void deleteFilm(Film film);
}
