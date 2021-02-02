package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Participant;
import com.eni.filmotheque.repositories.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealisateurServiceImpl implements RealisateurService{

    @Autowired
    private RealisateurRepository realisateurRepo;

    @Override
    public List<Participant> getListRealisateur() {
        return realisateurRepo.findAll();
    }

    @Override
    public Participant getRealisateurById(long id) {
        return realisateurRepo.findById(id).get();
    }
}
