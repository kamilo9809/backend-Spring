package com.group_3.backen_project.controllers.status_opportunities;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group_3.backen_project.controllers.status_opportunities.services.Status_opportunitiesServices;
import com.group_3.backen_project.models.Status_opportunities;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/status-opportunities")
public class Status_opportunitiesController {

    @Autowired
    private Status_opportunitiesServices statusOpportunitiesServices;

    @PostMapping
    public Status_opportunities postStatus(@RequestBody Status_opportunities status_opportunities) {
        return statusOpportunitiesServices.createStatus(status_opportunities);
    }

    @GetMapping
    public List<Status_opportunities> getStatusOpportunities() {
        return statusOpportunitiesServices.getAllStatus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status_opportunities> getOportunity(@PathVariable Long id) {
        Optional<Status_opportunities> statusOpportunity = statusOpportunitiesServices.getStatusById(id);
        return statusOpportunity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status_opportunities> putOpportunity(@PathVariable Long id, @RequestBody Status_opportunities detailsStatus) {      
        return ResponseEntity.ok(statusOpportunitiesServices.updateStatus(id, detailsStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Status_opportunities> deleteOportunity(@PathVariable Long id){
        statusOpportunitiesServices.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }

}
