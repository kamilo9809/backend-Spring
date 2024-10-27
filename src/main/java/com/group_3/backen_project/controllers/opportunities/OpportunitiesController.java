package com.group_3.backen_project.controllers.opportunities;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group_3.backen_project.controllers.opportunities.service.OpportunitiesServices;
import com.group_3.backen_project.models.Opportunities;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/opportunities")
public class OpportunitiesController {

    @Autowired
    private OpportunitiesServices opportunitiesServices;

    @PostMapping("/{idCategories}/{idStatus}/{idType}")
    public ResponseEntity<Opportunities> postOpportunities(
            @RequestBody Opportunities opportunities,
            @PathVariable Long idCategories,
            @PathVariable Long idStatus,
            @PathVariable Long idType) {

        return ResponseEntity
                .ok(opportunitiesServices.createOpportunities(opportunities, idCategories, idStatus, idType));
    }

    @GetMapping
    public List<Opportunities> getOpportunities() {
        return opportunitiesServices.getOpportunitiesAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opportunities> getOportunity(@PathVariable Long id) {
        Optional<Opportunities> opportunity = opportunitiesServices.getOpportunitiesById(id);
        return opportunity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Opportunities> putOpportunities(@PathVariable Long id,
            @RequestBody Opportunities detailOpportunities) {
        return ResponseEntity.ok(opportunitiesServices.updateOpportunities(id, detailOpportunities));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        opportunitiesServices.deleteOpportunities(id);
        return ResponseEntity.noContent().build();
    }
}
