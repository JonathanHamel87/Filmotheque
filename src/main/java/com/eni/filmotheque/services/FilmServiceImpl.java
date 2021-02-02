package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Film;
import com.eni.filmotheque.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepo;

    @Override
    public List<Film> getListFilm() {
        return filmRepo.findAll();
    }

    @Override
    public Film getFilmById(long id) {
        return filmRepo.findById(id).get();
    }

    @Override
    public void addFilm(Film film) {
        filmRepo.save(film);
    }

    @Override
    public void updateFilm(Film film) {
        filmRepo.save(film);
    }

    @Override
    public void deleteFilm(Film film) {
        filmRepo.delete(film);
    }

}
