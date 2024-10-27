package com.group_3.backen_project.controllers.categories_opportunities;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group_3.backen_project.controllers.categories_opportunities.services.Categories_OpportunitiesService;
import com.group_3.backen_project.models.Categories_opportunities;

@RestController
@RequestMapping("api/categories")
public class Categories_opportunitiesController {
    @Autowired
    private Categories_OpportunitiesService categoriesOpportunitiesService;

    @PostMapping
    public Categories_opportunities createCategory(@RequestBody Categories_opportunities categories_opportunities) {
        return categoriesOpportunitiesService.createCategory(categories_opportunities);
    }

    @GetMapping
    public List<Categories_opportunities> getAllCategories() {
        return categoriesOpportunitiesService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categories_opportunities> getCategoryById(@PathVariable Long id) {
        Optional<Categories_opportunities> category = categoriesOpportunitiesService.getCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categories_opportunities> updateCategory(@PathVariable Long id,
            @RequestBody Categories_opportunities categoryDetails) {
        return ResponseEntity.ok(categoriesOpportunitiesService.updateCategory(id, categoryDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoriesOpportunitiesService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}