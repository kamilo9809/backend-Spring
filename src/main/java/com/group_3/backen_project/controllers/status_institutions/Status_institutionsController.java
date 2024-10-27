package com.group_3.backen_project.controllers.status_institutions;

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

import com.group_3.backen_project.controllers.status_institutions.service.Status_institutionsServices;
import com.group_3.backen_project.models.Status_institutions;

@RestController
@RequestMapping("api/status-institutions")
public class Status_institutionsController {

     @Autowired
    private Status_institutionsServices statusInstitutionsServices;

    @PostMapping
    public Status_institutions postStatus(Status_institutions statusInstitutions) {
        return statusInstitutionsServices.createStatus(statusInstitutions);
    }

    @GetMapping
    public List<Status_institutions> getStatusiInstitutions() {
        return statusInstitutionsServices.getAllStatus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status_institutions> getStatusInstitutions(@PathVariable Long id) {
        Optional<Status_institutions> statusIstitutions = statusInstitutionsServices.getStatusById(id);
        return statusIstitutions.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status_institutions> putOpportunity(@PathVariable Long id, @RequestBody Status_institutions detailsStatus) {      
        return ResponseEntity.ok(statusInstitutionsServices.updateStatus(id, detailsStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Status_institutions> deleteOportunity(@PathVariable Long id){
        statusInstitutionsServices.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }
}
