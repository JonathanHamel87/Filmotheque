package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Categorie;
import com.eni.filmotheque.models.Film;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService{

    private List<Categorie> categories = new ArrayList();

    public CategorieServiceImpl() {
        Categorie categorie1 = new Categorie(1L, "Science-fiction");
        Categorie categorie2 = new Categorie(2L, "Action");
        Categorie categorie3 = new Categorie(3L, "Comédie");

        categories.add(categorie1);
        categories.add(categorie2);
        categories.add(categorie3);
    }

    @Override
    public List<Categorie> getListCategories() {
        return categories;
    }

    @Override
    public Categorie getCategorieById(long id) {
        Categorie categ = new Categorie();
        for(Categorie categorie: categories) {
            if(categorie.getIdCategorie() == id) {
                categ = categorie;
            }
        }
        return categ;
    }
}
