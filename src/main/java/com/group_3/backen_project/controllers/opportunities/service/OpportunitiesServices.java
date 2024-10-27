package com.group_3.backen_project.controllers.opportunities.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Categories_opportunities;
import com.group_3.backen_project.models.Opportunities;
import com.group_3.backen_project.models.Status_opportunities;
import com.group_3.backen_project.models.Type_opportunities;
import com.group_3.backen_project.repositories.CategoriesOpportunitiesRepository;
import com.group_3.backen_project.repositories.OpportunitiesRepository;
import com.group_3.backen_project.repositories.StatusOpportunitiesRepository;
import com.group_3.backen_project.repositories.TypeOpportunitiesRepository;

@Service
public class OpportunitiesServices {

    private OpportunitiesRepository opportunitiesRepository;
    private CategoriesOpportunitiesRepository categoriesOpportunitiesRepository;
    private StatusOpportunitiesRepository statusOpportunitiesRepository;
    private TypeOpportunitiesRepository typeOpportunitiesRepository;

    public OpportunitiesServices(
            OpportunitiesRepository opportunitiesRepository,
            CategoriesOpportunitiesRepository categoriesOpportunitiesRepository,
            StatusOpportunitiesRepository statusOpportunitiesRepository,
            TypeOpportunitiesRepository typeOpportunitiesRepository) {
        this.opportunitiesRepository = opportunitiesRepository;
        this.categoriesOpportunitiesRepository = categoriesOpportunitiesRepository;
        this.statusOpportunitiesRepository = statusOpportunitiesRepository;
        this.typeOpportunitiesRepository = typeOpportunitiesRepository;
    }

    public Opportunities createOpportunities(
            Opportunities opportunities,
            Long idCategories,
            Long idStatus,
            Long idOpportunityType) {

        Categories_opportunities categories_opportunities = categoriesOpportunitiesRepository.findById(idCategories)
                .orElseThrow(() -> new RuntimeException("id Categories not found"));

        Status_opportunities status_opportunities = statusOpportunitiesRepository.findById(idStatus)
                .orElseThrow(() -> new RuntimeException("id Status not found"));

        Type_opportunities type_opportunities = typeOpportunitiesRepository.findById(idOpportunityType)
                .orElseThrow(() -> new RuntimeException("id type opportunity not found"));

        opportunities.setIdCategories(categories_opportunities);
        opportunities.setIdStatus(status_opportunities);
        opportunities.setTypeOpportunities(type_opportunities);
        return opportunitiesRepository.save(opportunities);
    }

     public Optional<Opportunities> getOpportunitiesById(Long id){
        return opportunitiesRepository.findById(id);
    }

    public List<Opportunities> getOpportunitiesAll(){
        return opportunitiesRepository.findAll();
    }

    public Opportunities updateOpportunities(Long id, Opportunities detailOpportunities){
        Opportunities opportunities = opportunitiesRepository.findById(id).orElseThrow();
        opportunities.setObservations(detailOpportunities.getObservations());
        opportunities.setName(detailOpportunities.getName());
        opportunities.setDescriptions(detailOpportunities.getDescriptions());
        opportunities.setAplications(detailOpportunities.getAplications());
        opportunities.setRequeriments(detailOpportunities.getRequeriments());
        opportunities.setGuide(detailOpportunities.getGuide());
        opportunities.setAdicionalDates(detailOpportunities.getAdicionalDates());
        opportunities.setContactChannels(detailOpportunities.getContactChannels());
        return opportunitiesRepository.save(opportunities);
    }

    public void deleteOpportunities(Long id){
        opportunitiesRepository.deleteById(id);
    }

}
