package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Participant;
import com.eni.filmotheque.repositories.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActeurServiceImpl implements ActeurService {

    @Autowired
    private ActeurRepository acteurRepo;

    @Override
    public List<Participant> getListActeurs() {
        return acteurRepo.findAll();
    }

    @Override
    public List<Participant> getListActeursByListId(List<Long> ids) {
        List<Participant> listActeurs = new ArrayList<>();

        for (Long id: ids){
            listActeurs.add(acteurRepo.findById(id).get());
        }

        return listActeurs;
    }
}
