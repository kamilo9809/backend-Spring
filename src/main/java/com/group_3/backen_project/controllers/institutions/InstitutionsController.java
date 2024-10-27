package com.group_3.backen_project.controllers.institutions;

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

import com.group_3.backen_project.controllers.institutions.service.InstitutionsServices;
import com.group_3.backen_project.models.Institutions;



@RestController
@RequestMapping("api/institutions")
public class InstitutionsController {
    @Autowired
    private InstitutionsServices institutionsServices ;

    @PostMapping("/{idStatus}/{idUbication}")
    public ResponseEntity<Institutions> postInstitute(
            @RequestBody Institutions institutions,
            @PathVariable Long idStatus,
            @PathVariable Long idUbication) {

        return ResponseEntity
                .ok(institutionsServices.createInstitutions(institutions, idStatus, idUbication));
    }

    @GetMapping
    public List<Institutions> getiInstitutions() {
        return institutionsServices.getInstitutionsAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institutions> getInstitute(@PathVariable Long id) {
        Optional<Institutions> institute = institutionsServices.getInstitutionsById(id);
        return institute.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/{idStatus}/{idUbication}")
    public ResponseEntity<Institutions> putInstitutions(
            @PathVariable Long id,
            @PathVariable Long idStatus,
            @PathVariable Long idUbication,
            @RequestBody Institutions detailInstitutions) {
        return ResponseEntity
                .ok(institutionsServices.createInstitutions(detailInstitutions, idStatus, idUbication));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstitutions(@PathVariable Long id) {
        institutionsServices.deleteInstitutions(id);
        return ResponseEntity.noContent().build();
    }
}
