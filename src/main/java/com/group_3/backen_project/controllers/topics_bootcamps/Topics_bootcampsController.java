package com.group_3.backen_project.controllers.topics_bootcamps;

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

import com.group_3.backen_project.controllers.topics_bootcamps.services.Topic_bootcampServices;
import com.group_3.backen_project.models.Topics_bootcamps;

@RestController
@RequestMapping("api/topics")
public class Topics_bootcampsController {
    @Autowired
    private Topic_bootcampServices topicBootcampsService;

    @PostMapping
    public Topics_bootcamps postTopic(@RequestBody Topics_bootcamps descriptionsTopics) {
        return topicBootcampsService.createTopic(descriptionsTopics);
    }

    @GetMapping
    public List<Topics_bootcamps> getTopics() {
        return topicBootcampsService.getAllTopics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topics_bootcamps> getTopic(@PathVariable Long id) {
        Optional<Topics_bootcamps> topics = topicBootcampsService.getTopicById(id);
        return topics.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topics_bootcamps> putTopic(@PathVariable Long id, @RequestBody Topics_bootcamps detailstopic) {      
        return ResponseEntity.ok(topicBootcampsService.updateTopics(id, detailstopic));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Topics_bootcamps> deleteTopic(@PathVariable Long id){
        topicBootcampsService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

}
