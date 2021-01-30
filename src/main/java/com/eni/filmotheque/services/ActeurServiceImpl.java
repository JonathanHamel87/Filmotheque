package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Participant;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActeurServiceImpl implements ActeurService {

    private List<Participant> acteurs = new ArrayList();

    public ActeurServiceImpl() {
        Participant acteur1 = new Participant(4L, "Ford", "Harrison");
        Participant acteur2 = new Participant(5L, "Thurman", "Uma");
        Participant acteur3 = new Participant(6L, "Neill", "Sam");

        acteurs.add(acteur1);
        acteurs.add(acteur2);
        acteurs.add(acteur3);
    }

    @Override
    public List<Participant> getListActeurs() {

        return acteurs;
    }

    @Override
    public List<Participant> getListActeursByListId(List<Long> ids) {
        List<Participant> listActeurs = new ArrayList<>();

        for (long id: ids){
            Participant act = new Participant();
            for (Participant acteur: acteurs){
                if (acteur.getIdParticipant() == id){
                    act = acteur;
                }
            }
            listActeurs.add(act);
        }

        return listActeurs;
    }
}
