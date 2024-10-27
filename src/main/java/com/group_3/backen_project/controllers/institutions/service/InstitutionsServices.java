package com.group_3.backen_project.controllers.institutions.service;

import java.util.*;
import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Institutions;
import com.group_3.backen_project.models.Status_institutions;
import com.group_3.backen_project.models.Ubications_institutions;
import com.group_3.backen_project.repositories.InstitutionsRepository;
import com.group_3.backen_project.repositories.StatusInstitutionsRepository;
import com.group_3.backen_project.repositories.UbicationsInstitutionsRepository;

@Service
public class InstitutionsServices {

    private InstitutionsRepository institutionsRepository;
    private StatusInstitutionsRepository statusInstitutionsRepository;
    private UbicationsInstitutionsRepository ubicationsInstitutionsRepository;

    public InstitutionsServices(
            InstitutionsRepository institutionsRepository,
            StatusInstitutionsRepository statusInstitutionsRepository,
            UbicationsInstitutionsRepository ubicationsInstitutionsRepository) {
        this.institutionsRepository = institutionsRepository;
        this.statusInstitutionsRepository = statusInstitutionsRepository;
        this.ubicationsInstitutionsRepository = ubicationsInstitutionsRepository;
    }

    public Institutions createInstitutions(
            Institutions institutions,
            Long idStatus,
            Long idUbications
            ) {

        Status_institutions status = statusInstitutionsRepository.findById(idStatus)
                .orElseThrow(() -> new RuntimeException("id status not found"));

        Ubications_institutions ubications = ubicationsInstitutionsRepository.findById(idUbications)
                .orElseThrow(() -> new RuntimeException("id Ubications not found"));

        institutions.setIdStatus(status);
        institutions.setUbicationsInstitutions(ubications);
        return institutionsRepository.save(institutions);
    }

    public Optional<Institutions> getInstitutionsById(Long id) {
        return institutionsRepository.findById(id);
    }

    public List<Institutions> getInstitutionsAll() {
        return institutionsRepository.findAll();
    }

    public Institutions updateInstitutions(Long id, Institutions detaiInstitutions,
            Long idStatus, Long idUbications) {
        Institutions institutions = institutionsRepository.findById(id).orElseThrow();

        Status_institutions status = statusInstitutionsRepository.findById(idStatus)
                .orElseThrow(() -> new RuntimeException("id status not found"));

        Ubications_institutions ubications = ubicationsInstitutionsRepository.findById(idUbications)
                .orElseThrow(() -> new RuntimeException("id Ubications not found"));

        institutions.setIdStatus(status);
        institutions.setUbicationsInstitutions(ubications);

        institutions.setDirections(detaiInstitutions.getDirections());
        institutions.setGeneralLink(detaiInstitutions.getGeneralLink());
        institutions.setCarerLink(detaiInstitutions.getCarerLink());
        institutions.setBienestarLink(detaiInstitutions.getBienestarLink());
        institutions.setProccesLink(detaiInstitutions.getProccesLink());
        return institutionsRepository.save(institutions);
    }

    public void deleteInstitutions(Long id) {
        institutionsRepository.deleteById(id);
    }
}
