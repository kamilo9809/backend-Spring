package com.group_3.backen_project.controllers.status_bootcamps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Status_bootcamps;
import com.group_3.backen_project.repositories.StatusBootcampsRepository;

@Service
public class Status_bootcampServices {

    @Autowired
    private StatusBootcampsRepository statusBootcampsRepository;

     public Status_bootcamps createStatus(Status_bootcamps status) {
        return statusBootcampsRepository.save(status);
    }

    public Optional<Status_bootcamps> geStatusById(Long id) {
        return statusBootcampsRepository.findById(id);
    }

    public List<Status_bootcamps> getAllStatus() {
        return statusBootcampsRepository.findAll();
    }

    public Status_bootcamps updateStatus(Long id, Status_bootcamps detailStatus) {
        Status_bootcamps status = statusBootcampsRepository.findById(id).orElseThrow();
        status.setStatus(detailStatus.getStatus());
        return statusBootcampsRepository.save(status);
    }

    public void deleteStatus(Long id) {
        statusBootcampsRepository.deleteById(id);
    }

}
