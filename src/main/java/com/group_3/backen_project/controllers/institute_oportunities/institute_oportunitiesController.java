package com.group_3.backen_project.controllers.institute_oportunities;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group_3.backen_project.controllers.institute_oportunities.service.Institute_oportunitiesservice;
import com.group_3.backen_project.models.Institute_opportunities;

@RestController
@RequestMapping("api/institute-opportunity")
public class Institute_oportunitiesController {

    @Autowired
    private Institute_oportunitiesservice institute_oportunitiesservice;

    @PostMapping("/{idInstitute}/{idOpportunity}")
    public ResponseEntity<Institute_opportunities> postInstituteOpportunity(@PathVariable Long idInstitute,
            @PathVariable Long idOpportunity) {
        return ResponseEntity.ok(institute_oportunitiesservice.createInstitutionsOpp(idInstitute, idOpportunity));
    }

    @GetMapping
    public List<Institute_opportunities> getInstituteOpportunities() {
        return institute_oportunitiesservice.getalllInstituteOportunities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institute_opportunities> getInstituteOpportunity(@PathVariable Long id) {
        Optional<Institute_opportunities> instituteOpportunity = institute_oportunitiesservice.getByIdInstituteOpportunities(id);
        return instituteOpportunity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/{idInstitute}/{idOpportunity}")
    public ResponseEntity<Institute_opportunities> putUserOpportunity(
            @PathVariable Long id,
            @PathVariable Long idInstitute,
            @PathVariable Long idOpportunity) {

        return ResponseEntity.ok(institute_oportunitiesservice.updateinstituteOportunities(id, idInstitute, idOpportunity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserOpportunity(@PathVariable Long id){
        institute_oportunitiesservice.deleteInstitutionsOpportunities(id);
        return ResponseEntity.noContent().build();
    }
}
