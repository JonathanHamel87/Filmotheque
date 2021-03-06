package com.eni.filmotheque.repositories;

import com.eni.filmotheque.models.Categorie;
import com.eni.filmotheque.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    @Query("SELECT c FROM Categorie c WHERE c.label = ?1")
    public Categorie findOneByLabel(String label);

}
