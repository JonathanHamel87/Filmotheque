package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Participant;

import java.util.List;
import java.util.Optional;

public interface ActeurService {
    public List<Participant> getListActeurs();
    public List<Participant> getListActeursByListId(List<Long> ids);
}
