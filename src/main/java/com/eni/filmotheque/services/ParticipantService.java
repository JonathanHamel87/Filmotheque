package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Participant;

import java.util.List;

public interface ParticipantService {
    public List<Participant> getListParticipant();
    public Participant getParticipantById(long id);
    public List<Participant> getListParticipantsByListId(List<Long> ids);
    public Participant getParticipantByNomPrenom(String nom, String prenom);
    public void addParticipant(Participant participant);
}
