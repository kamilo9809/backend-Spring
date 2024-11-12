package com.group_3.backen_project.controllers.institute_bootcamps;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group_3.backen_project.controllers.institute_bootcamps.service.Institute_bootcampsservice;
import com.group_3.backen_project.models.Institute_bootcamps;

@RestController
@RequestMapping("api/institute-bootcamps")
public class Institute_bootcampsController {
    private Institute_bootcampsservice instituteBootcampsService;

     @PostMapping("/{idInstitute}/{idBootcamps}")
    public ResponseEntity<Institute_bootcamps> postInstituteBootcamps(@PathVariable Long idInstitute,
            @PathVariable Long idBootcamps) {
        return ResponseEntity.ok(instituteBootcampsService.createInstitutionsBootcamps(idInstitute, idBootcamps));
    }

    @GetMapping
    public List<Institute_bootcamps> getInstituteBootcamps() {
        return instituteBootcampsService.getalllInstituteBootcamps();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Institute_bootcamps> getInstituteBootcamps(@PathVariable Long id) {
        Optional<Institute_bootcamps> instituteBootcampas = instituteBootcampsService.getByIdInstituteBootcamps(id);
        return instituteBootcampas.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/{idInstitute}/{idBootcamps}")
    public ResponseEntity<Institute_bootcamps> putUserBootcamps(
            @PathVariable Long id,
            @PathVariable Long idInstitute,
            @PathVariable Long idBootcamps) {

        return ResponseEntity.ok(instituteBootcampsService.updateinstituteBootcamps(id, idInstitute, idBootcamps));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserOpportunity(@PathVariable Long id){
        instituteBootcampsService.deleteInstitutionsBootcamps(id);
        return ResponseEntity.noContent().build();
    }

}
