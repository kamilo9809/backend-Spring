package com.group_3.backen_project.controllers.categories_opportunities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Categories_opportunities;
import com.group_3.backen_project.repositories.CategoriesOpportunitiesRepository;

import java.util.*;

@Service
public class Categories_OpportunitiesService {
    @Autowired
    private CategoriesOpportunitiesRepository categoriesOpportunitiesRepository;

    public Categories_opportunities createCategory(Categories_opportunities categories_opportunities){
        return categoriesOpportunitiesRepository.save(categories_opportunities);
    }

    public Optional<Categories_opportunities> getCategoryById(Long id) {
        return categoriesOpportunitiesRepository.findById(id);
    }

    public List<Categories_opportunities> getAllCategories() {
        return categoriesOpportunitiesRepository.findAll();
    }

    public Categories_opportunities updateCategory(Long id, Categories_opportunities detailCategory) {
        Categories_opportunities categories = categoriesOpportunitiesRepository.findById(id).orElseThrow();
        categories.setCategories(detailCategory.getCategories());
        return categoriesOpportunitiesRepository.save(categories);
    }

    public void deleteCategory(Long id) {
        categoriesOpportunitiesRepository.deleteById(id);
    }
}
