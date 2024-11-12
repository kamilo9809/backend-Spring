package com.group_3.backen_project.controllers.topics_bootcamps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Topics_bootcamps;
import com.group_3.backen_project.repositories.TopicsBootcampsRepository;

@Service
public class Topic_bootcampServices {

    @Autowired
    private TopicsBootcampsRepository topicsBootcampsRepository;

    public Topics_bootcamps createTopic(Topics_bootcamps topicsBootcamps) {
        return topicsBootcampsRepository.save(topicsBootcamps);
    }

    public Optional<Topics_bootcamps> getTopicById(Long id) {
        return topicsBootcampsRepository.findById(id);
    }

    public List<Topics_bootcamps> getAllTopics() {
        return topicsBootcampsRepository.findAll();
    }

    public Topics_bootcamps updateTopics(Long id, Topics_bootcamps detailTopics) {
        Topics_bootcamps topics = topicsBootcampsRepository.findById(id).orElseThrow();
        topics.setTopics(detailTopics.getTopics());
        return topicsBootcampsRepository.save(topics);
    }

    public void deleteTopic(Long id) {
        topicsBootcampsRepository.deleteById(id);
    }
}
