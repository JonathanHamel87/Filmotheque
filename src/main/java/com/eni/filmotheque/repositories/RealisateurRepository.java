package com.eni.filmotheque.repositories;

import com.eni.filmotheque.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealisateurRepository extends JpaRepository<Participant, Long> {
}
