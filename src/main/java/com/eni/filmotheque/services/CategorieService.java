package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Categorie;

import java.util.List;
import java.util.Optional;

public interface CategorieService {
    public List<Categorie> getListCategories();
    public Categorie getCategorieById(long id);
    public Categorie getCategorieByLabel(String label);
    public void addCategorie(Categorie categorie);
}
