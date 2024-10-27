package com.group_3.backen_project.controllers.ubications_institutions.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Ubications_institutions;
import com.group_3.backen_project.repositories.UbicationsInstitutionsRepository;

@Service
public class Ubications_institutionsService {
     @Autowired
    private UbicationsInstitutionsRepository ubicationsInstitutionsRepository;

    public Ubications_institutions createUbication(Ubications_institutions ubications){
        return ubicationsInstitutionsRepository.save(ubications);
    }

    public Optional<Ubications_institutions> getubicationById(Long id) {
        return ubicationsInstitutionsRepository.findById(id);
    }

    public List<Ubications_institutions> getAllUbications() {
        return ubicationsInstitutionsRepository.findAll();
    }

    public Ubications_institutions updateUbications(Long id, Ubications_institutions detailsUbications) {
        Ubications_institutions ubication = ubicationsInstitutionsRepository.findById(id).orElseThrow();
        ubication.setZona(detailsUbications.getZona());
        return ubicationsInstitutionsRepository.save(ubication);
    }

    public void deleteUbication(Long id) {
        ubicationsInstitutionsRepository.deleteById(id);
    }
}
