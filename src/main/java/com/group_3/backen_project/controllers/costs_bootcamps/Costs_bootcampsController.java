package com.group_3.backen_project.controllers.costs_bootcamps;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group_3.backen_project.controllers.costs_bootcamps.service.Costs_bootcampsServices;
import com.group_3.backen_project.models.Costs_bootcamps;

@RestController
@RequestMapping("api/cost")
public class Costs_bootcampsController {

    @Autowired
    private Costs_bootcampsServices costService;

    public Costs_bootcamps postCosts(@RequestBody Costs_bootcamps CostsBootcamps) {
        return costService.createCost(CostsBootcamps);
    }

    @GetMapping
    public List<Costs_bootcamps> getCostsBootcamps() {
        return costService.getAllCost();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Costs_bootcamps> geCostsBootcamp(@PathVariable Long id) {
        Optional<Costs_bootcamps> costsBootcamps = costService.geCostById(id);
        return costsBootcamps.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Costs_bootcamps> putCostsBootcamps(@PathVariable Long id, @RequestBody Costs_bootcamps detailsCosts) {      
        return ResponseEntity.ok(costService.updateCost(id, detailsCosts));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Costs_bootcamps> deleteCostsBootcamps(@PathVariable Long id){
        costService.deleteCost(id);
        return ResponseEntity.noContent().build();
    }

}
