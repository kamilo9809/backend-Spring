package com.group_3.backen_project.controllers.bootcamps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Bootcamps;
import com.group_3.backen_project.models.Costs_bootcamps;
import com.group_3.backen_project.models.Descriptions_bootcamps;
import com.group_3.backen_project.models.Status_bootcamps;
import com.group_3.backen_project.models.Topics_bootcamps;
import com.group_3.backen_project.repositories.BootcampsRepository;
import com.group_3.backen_project.repositories.CostsBootcampsRepository;
import com.group_3.backen_project.repositories.DescriptionsBootcampsRepository;
import com.group_3.backen_project.repositories.StatusBootcampsRepository;
import com.group_3.backen_project.repositories.TopicsBootcampsRepository;

@Service
public class BootcampsSevices {
    private BootcampsRepository bootcampsRepository;
    private DescriptionsBootcampsRepository descriptionsBootcampsRepository;
    private CostsBootcampsRepository costsBootcampsRepository;
    private StatusBootcampsRepository statusBootcampsRepository;
    private TopicsBootcampsRepository topicsBootcampsRepository;

    public BootcampsSevices(
            BootcampsRepository bootcampsRepository,
            DescriptionsBootcampsRepository descriptionsBootcampsRepository,
            CostsBootcampsRepository costsBootcampsRepository,
            StatusBootcampsRepository statusBootcampsRepository,
            TopicsBootcampsRepository topicsBootcampsRepository) {
        this.bootcampsRepository = bootcampsRepository;
        this.descriptionsBootcampsRepository = descriptionsBootcampsRepository;
        this.costsBootcampsRepository = costsBootcampsRepository;
        this.statusBootcampsRepository = statusBootcampsRepository;
        this.topicsBootcampsRepository = topicsBootcampsRepository;
    }

    public Bootcamps createBootcamps(
            Bootcamps bootcamps,
            Long idDescriptions,
            Long idTopics,
            Long idCosts,
            Long idStatus) {

        Descriptions_bootcamps descriptions = descriptionsBootcampsRepository.findById(idDescriptions)
                .orElseThrow(() -> new RuntimeException("Description id not found"));

        Topics_bootcamps topics = topicsBootcampsRepository.findById(idTopics)
                .orElseThrow(() -> new RuntimeException("Topics id not found"));

        Costs_bootcamps costs = costsBootcampsRepository.findById(idCosts)
                .orElseThrow(() -> new RuntimeException("Costs id not found"));

        Status_bootcamps status = statusBootcampsRepository.findById(idStatus)
                .orElseThrow(() -> new RuntimeException("Status id not"));

        bootcamps.setIdGeneral(descriptions);
        bootcamps.setIdTemas(topics);
        bootcamps.setIdCostos(costs);
        bootcamps.setIdEstado(status);

        return bootcampsRepository.save(bootcamps);
    }

    public List<Bootcamps> getAllBootcamps() {
        return bootcampsRepository.findAll();
    }

    public Optional<Bootcamps> getByIdBootcamps(Long id) {
        return bootcampsRepository.findById(id);
    }

    public Bootcamps updateBootcamps(
            Long id,
            Bootcamps detailsbootcamps,
            Long idDescriptions,
            Long idTopics,
            Long idCosts,
            Long idStatus) {

        Bootcamps bootcamps = bootcampsRepository.findById(id).orElseThrow();

        Descriptions_bootcamps descriptions = descriptionsBootcampsRepository.findById(idDescriptions)
                .orElseThrow(() -> new RuntimeException("Description id not found"));

        Topics_bootcamps topics = topicsBootcampsRepository.findById(idTopics)
                .orElseThrow(() -> new RuntimeException("Topics id not found"));

        Costs_bootcamps costs = costsBootcampsRepository.findById(idCosts)
                .orElseThrow(() -> new RuntimeException("Costs id not found"));

        Status_bootcamps status = statusBootcampsRepository.findById(idStatus)
                .orElseThrow(() -> new RuntimeException("Status id not"));

        bootcamps.setIdGeneral(descriptions);
        bootcamps.setIdTemas(topics);
        bootcamps.setIdCostos(costs);
        bootcamps.setIdEstado(status);

        bootcamps.setNombre(detailsbootcamps.getNombre());

        return bootcampsRepository.save(bootcamps);
    }

    public void deleteBootcamps(Long id) {
        bootcampsRepository.deleteById(id);
    }
}