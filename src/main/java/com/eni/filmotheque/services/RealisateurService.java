package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Participant;

import java.util.List;

public interface RealisateurService {
    public List<Participant> getListRealisateur();
    public Participant getRealisateurById(long id);
}
