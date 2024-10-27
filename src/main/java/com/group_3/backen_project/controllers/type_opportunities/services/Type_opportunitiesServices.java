package com.group_3.backen_project.controllers.type_opportunities.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Type_opportunities;
import com.group_3.backen_project.repositories.TypeOpportunitiesRepository;

@Service
public class Type_opportunitiesServices {
    @Autowired
    private TypeOpportunitiesRepository typeOpportunitiesRepository;

    public Type_opportunities createType(Type_opportunities type){
        return typeOpportunitiesRepository.save(type);
    }

    public Optional<Type_opportunities> getTypeById(Long id) {
        return typeOpportunitiesRepository.findById(id);
    }

    public List<Type_opportunities> getAllType() {
        return typeOpportunitiesRepository.findAll();
    }

    public Type_opportunities updateType(Long id, Type_opportunities detailsType) {
        Type_opportunities type = typeOpportunitiesRepository.findById(id).orElseThrow();
        type.setOportunityType(detailsType.getOportunityType());
        return typeOpportunitiesRepository.save(type);
    }

    public void deleteType(Long id) {
        typeOpportunitiesRepository.deleteById(id);
    }
}
