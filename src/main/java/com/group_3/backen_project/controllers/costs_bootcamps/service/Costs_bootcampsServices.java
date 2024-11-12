package com.group_3.backen_project.controllers.costs_bootcamps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Costs_bootcamps;
import com.group_3.backen_project.repositories.CostsBootcampsRepository;

@Service
public class Costs_bootcampsServices {
    @Autowired
    private CostsBootcampsRepository costsBootcampsRepository;

    public Costs_bootcamps createCost(Costs_bootcamps Costs) {
        return costsBootcampsRepository.save(Costs);
    }

    public Optional<Costs_bootcamps> geCostById(Long id) {
        return costsBootcampsRepository.findById(id);
    }

    public List<Costs_bootcamps> getAllCost() {
        return costsBootcampsRepository.findAll();
    }

    public Costs_bootcamps updateCost(Long id, Costs_bootcamps detailCosts) {
        Costs_bootcamps costs = costsBootcampsRepository.findById(id).orElseThrow();
        costs.setCosts(detailCosts.getCosts());
        return costsBootcampsRepository.save(costs);
    }

    public void deleteCost(Long id) {
        costsBootcampsRepository.deleteById(id);
    }

}
