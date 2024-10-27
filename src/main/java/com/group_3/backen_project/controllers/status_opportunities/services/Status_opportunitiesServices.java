package com.group_3.backen_project.controllers.status_opportunities.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Status_opportunities;
import com.group_3.backen_project.repositories.StatusOpportunitiesRepository;

@Service
public class Status_opportunitiesServices {

    @Autowired
    private StatusOpportunitiesRepository statusOpportunitiesRepository;

    public Status_opportunities createStatus(Status_opportunities status_opportunities){
        return statusOpportunitiesRepository.save(status_opportunities);
    }
    
    public Optional<Status_opportunities> getStatusById(Long id){
        return statusOpportunitiesRepository.findById(id);
    }

    public List<Status_opportunities> getAllStatus(){
        return statusOpportunitiesRepository.findAll();
    }

    public Status_opportunities updateStatus(Long id, Status_opportunities detailStatus){
        Status_opportunities status_opportunities = statusOpportunitiesRepository.findById(id).orElseThrow();
        status_opportunities.setStatus(detailStatus.getStatus());
        return statusOpportunitiesRepository.save(status_opportunities);
    }

    public void deleteStatus(Long id){
        statusOpportunitiesRepository.deleteById(id);
    }
}
