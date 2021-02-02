package com.eni.filmotheque.services;

import com.eni.filmotheque.models.Categorie;
import com.eni.filmotheque.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService{

    @Autowired
    private CategorieRepository categorieRepo;

    @Override
    public List<Categorie> getListCategories() {
        return categorieRepo.findAll();
    }

    @Override
    public Categorie getCategorieById(long id) {
        return categorieRepo.findById(id).get();
    }
}
