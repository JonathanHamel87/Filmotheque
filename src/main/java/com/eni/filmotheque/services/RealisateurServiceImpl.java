package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Participant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RealisateurServiceImpl implements RealisateurService{

    private List<Participant> realisateurs = new ArrayList();

    public RealisateurServiceImpl() {
        Participant realisateur1 = new Participant(1L, "Lucas", "Georges");
        Participant realisateur2 = new Participant(2L, "Tarantino", "Quentin");
        Participant realisateur3 = new Participant(3L, "Spielberg", "Steven");

        realisateurs.add(realisateur1);
        realisateurs.add(realisateur2);
        realisateurs.add(realisateur3);
    }

    @Override
    public List<Participant> getListRealisateur() {
        return realisateurs;
    }

    @Override
    public Participant getRealisateurById(long id) {
        Participant real = new Participant();
        for (Participant realisateur: realisateurs){
            if (realisateur.getIdParticipant() == id){
                real = realisateur;
            }
        }

        return real;
    }
}
