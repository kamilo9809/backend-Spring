package com.group_3.backen_project.controllers.status_institutions.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Status_institutions;
import com.group_3.backen_project.repositories.StatusInstitutionsRepository;

@Service
public class Status_institutionsServices {
    @Autowired
    private StatusInstitutionsRepository statusInstitutionsRepository;

    public Status_institutions createStatus(Status_institutions statusInstitutions) {
        return statusInstitutionsRepository.save(statusInstitutions);
    }

    public Optional<Status_institutions> getStatusById(Long id) {
        return statusInstitutionsRepository.findById(id);
    }

    public List<Status_institutions> getAllStatus() {
        return statusInstitutionsRepository.findAll();
    }

    public Status_institutions updateStatus(Long id, Status_institutions detailStatus) {
        Status_institutions statusInstitutions = statusInstitutionsRepository.findById(id).orElseThrow();
        statusInstitutions.setStatusReview(detailStatus.getStatusReview());
        return statusInstitutionsRepository.save(statusInstitutions);
    }

    public void deleteStatus(Long id) {
        statusInstitutionsRepository.deleteById(id);
    }
}
