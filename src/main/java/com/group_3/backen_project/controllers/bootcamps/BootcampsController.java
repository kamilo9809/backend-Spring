package com.group_3.backen_project.controllers.bootcamps;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group_3.backen_project.controllers.bootcamps.service.BootcampsSevices;
import com.group_3.backen_project.models.Bootcamps;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("api/bootcamps")
public class BootcampsController {
    @Autowired
    private BootcampsSevices bootcampsSevices;

    @PostMapping("/{idDescription}/{idTopics}/{idCosts}/{idStatus}")
    public ResponseEntity<Bootcamps> postBootcamps(
            @RequestBody Bootcamps bootcamps,
            @PathVariable Long idDescription,
            @PathVariable Long idTopics,
            @PathVariable Long idCosts,
            @PathVariable Long idStatus) {

        return ResponseEntity
                .ok(bootcampsSevices.createBootcamps(bootcamps, idDescription, idTopics, idCosts, idStatus));
    }

    @GetMapping
    public List<Bootcamps> getBootcamps() {
        return bootcampsSevices.getAllBootcamps();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bootcamps> getBootcamp(@PathVariable Long id) {
        Optional<Bootcamps> bootcamp = bootcampsSevices.getByIdBootcamps(id);
        return bootcamp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/{idDescription}/{idTopics}/{idCosts}/{idStatus}")
    public ResponseEntity<Bootcamps> putBootcamp(
        @PathVariable String id, 
        @RequestBody Bootcamps detailBootcamps,
        @PathVariable Long idDescription,
        @PathVariable Long idTopics,
        @PathVariable Long idCosts,
        @PathVariable Long idStatus
        ) {
        
        return ResponseEntity
            .ok(bootcampsSevices.updateBootcamps(idStatus, detailBootcamps, 
            idDescription, idTopics, idCosts, idStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBootcamps(@PathVariable Long id){
        bootcampsSevices.deleteBootcamps(id);
        return ResponseEntity.noContent().build();
    }

}
