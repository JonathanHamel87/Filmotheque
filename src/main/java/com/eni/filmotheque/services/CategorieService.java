package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Categorie;

import java.util.List;

public interface CategorieService {
    public List<Categorie> getListCategories();
    public Categorie getCategorieById(long id);
}
