package com.group_3.backen_project.controllers.description_bootcamps;

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

import com.group_3.backen_project.controllers.description_bootcamps.description_bootcamps.Description_bootcampsService;
import com.group_3.backen_project.models.Descriptions_bootcamps;

@RestController
@RequestMapping("api/description-bootcamps")
public class Description_bootcampsController {
    @Autowired
    private Description_bootcampsService descriptionsService;

     public Descriptions_bootcamps postDescriptions(@RequestBody Descriptions_bootcamps descriptionsBootcamps) {
        return descriptionsService.createDescriptions(descriptionsBootcamps);
    }

    @GetMapping
    public List<Descriptions_bootcamps> getDescriptionsBootcamps() {
        return descriptionsService.getAllDescriptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Descriptions_bootcamps> getDescriptionBootcamp(@PathVariable Long id) {
        Optional<Descriptions_bootcamps> descriptionsBootcamps = descriptionsService.getDescriptionById(id);
        return descriptionsBootcamps.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Descriptions_bootcamps> putDescriptionsBootcamps(@PathVariable Long id, @RequestBody Descriptions_bootcamps detailsDescriptions) {      
        return ResponseEntity.ok(descriptionsService.updateDescriptions(id, detailsDescriptions));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Descriptions_bootcamps> deleteDescriptionsBootcamps(@PathVariable Long id){
        descriptionsService.deleteDescriptions(id);
        return ResponseEntity.noContent().build();
    }
}
