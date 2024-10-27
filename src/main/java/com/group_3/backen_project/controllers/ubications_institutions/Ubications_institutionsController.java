package com.group_3.backen_project.controllers.ubications_institutions;

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

import com.group_3.backen_project.controllers.ubications_institutions.services.Ubications_institutionsService;
import com.group_3.backen_project.models.Ubications_institutions;


@RestController
@RequestMapping("api/ubications-institutions")
public class Ubications_institutionsController {
     @Autowired
    private Ubications_institutionsService uInstitutionsService;

    @PostMapping
    public Ubications_institutions createUbication(@RequestBody Ubications_institutions ubication){
        return uInstitutionsService.createUbication(ubication);
    }

    @GetMapping
    public List<Ubications_institutions> getAllUbications() {
        return uInstitutionsService.getAllUbications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ubications_institutions> getUbicationById(@PathVariable Long id) {
        Optional<Ubications_institutions> ubication = uInstitutionsService.getubicationById(id);
        return ubication.map(ResponseEntity::ok).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ubications_institutions> updateUbication(@PathVariable Long id, @RequestBody
    Ubications_institutions detailsUbications) {
        return ResponseEntity.ok(uInstitutionsService.updateUbications(id, detailsUbications));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUbication(@PathVariable Long id) {
        uInstitutionsService.deleteUbication(id);
        return ResponseEntity.noContent().build();
    }
}
