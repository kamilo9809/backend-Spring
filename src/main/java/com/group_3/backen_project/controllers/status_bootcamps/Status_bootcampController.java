package com.group_3.backen_project.controllers.status_bootcamps;

import java.util.List;
import java.util.Optional;

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

import com.group_3.backen_project.controllers.status_bootcamps.service.Status_bootcampServices;
import com.group_3.backen_project.models.Status_bootcamps;

@RestController
@RequestMapping("api/status-bootcamps")
public class Status_bootcampController {

    @Autowired
    private Status_bootcampServices statusBootcampsService;

    @PostMapping
    public Status_bootcamps postStatus(@RequestBody Status_bootcamps statusBootcamps) {
        return statusBootcampsService.createStatus(statusBootcamps);
    }

    @GetMapping
    public List<Status_bootcamps> getStatusBootcamps() {
        return statusBootcampsService.getAllStatus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status_bootcamps> geStatusBootcamp(@PathVariable Long id) {
        Optional<Status_bootcamps> statusBootcamps = statusBootcampsService.geStatusById(id);
        return statusBootcamps.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status_bootcamps> putStatusBootcamps(@PathVariable Long id, @RequestBody Status_bootcamps detailsStatus) {      
        return ResponseEntity.ok(statusBootcampsService.updateStatus(id, detailsStatus));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Status_bootcamps> deleteStatusBootcamps(@PathVariable Long id){
        statusBootcampsService.deleteStatus(id);
        return ResponseEntity.noContent().build();
    }

}
