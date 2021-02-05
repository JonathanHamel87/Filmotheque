package com.eni.filmotheque.repositories;

import com.eni.filmotheque.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @Query("SELECT p FROM Participant p WHERE p.nom = ?1 AND p.prenom = ?2")
    public Participant findByNomPrenom(String nom, String prenom);
}
