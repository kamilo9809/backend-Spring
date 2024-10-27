package com.group_3.backen_project.controllers.type_opportunities;

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

import com.group_3.backen_project.controllers.type_opportunities.services.Type_opportunitiesServices;
import com.group_3.backen_project.models.Type_opportunities;

@RestController
@RequestMapping("api/type-opportunity")
public class Type_opportunitiesController {
    @Autowired
    private Type_opportunitiesServices typeOpportunitiesServices;

    @PostMapping
    public Type_opportunities createType(@RequestBody Type_opportunities type){
        return typeOpportunitiesServices.createType(type);
    }

    @GetMapping
    public List<Type_opportunities> getAllType() {
        return typeOpportunitiesServices.getAllType();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Type_opportunities> getTypeById(@PathVariable Long id) {
        Optional<Type_opportunities> type = typeOpportunitiesServices.getTypeById(id);
        return type.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Type_opportunities> updateType(@PathVariable Long id, @RequestBody
    Type_opportunities detailsType) {
        return ResponseEntity.ok(typeOpportunitiesServices.updateType(id, detailsType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Long id) {
        typeOpportunitiesServices.deleteType(id);
        return ResponseEntity.noContent().build();
    }
}