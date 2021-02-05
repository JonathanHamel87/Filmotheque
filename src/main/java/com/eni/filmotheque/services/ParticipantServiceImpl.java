package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Participant;
import com.eni.filmotheque.repositories.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService{

    @Autowired
    private ParticipantRepository participantRepo;

    @Override
    public List<Participant> getListParticipant() {
        return participantRepo.findAll();
    }

    @Override
    public Participant getParticipantById(long id) {
        return participantRepo.findById(id).get();
    }

    @Override
    public List<Participant> getListParticipantsByListId(List<Long> ids) {
        List<Participant> listParticipants = new ArrayList<>();

        for (Long id: ids){
            listParticipants.add(participantRepo.findById(id).get());
        }

        return listParticipants;
    }

    @Override
    public Participant getParticipantByNomPrenom(String nom, String prenom) {
        Participant participant = participantRepo.findByNomPrenom(nom, prenom);

        if (participant == null)
            participant = new Participant();

        return participant;
    }

    @Override
    public void addParticipant(Participant participant) {
        participantRepo.save(participant);
    }
}
