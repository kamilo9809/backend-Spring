package com.group_3.backen_project.controllers.description_bootcamps.description_bootcamps;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Descriptions_bootcamps;
import com.group_3.backen_project.repositories.DescriptionsBootcampsRepository;

@Service
public class Description_bootcampsService {

    @Autowired
    private DescriptionsBootcampsRepository descriptionsBootcampsRepository;

     public Descriptions_bootcamps createDescriptions(Descriptions_bootcamps descriptionsBootcamps) {
        return descriptionsBootcampsRepository.save(descriptionsBootcamps);
    }

    public Optional<Descriptions_bootcamps> getDescriptionById(Long id) {
        return descriptionsBootcampsRepository.findById(id);
    }

    public List<Descriptions_bootcamps> getAllDescriptions() {
        return descriptionsBootcampsRepository.findAll();
    }

    public Descriptions_bootcamps updateDescriptions(Long id, Descriptions_bootcamps detailDescriptions) {
        Descriptions_bootcamps descriptionsBootcamps = descriptionsBootcampsRepository.findById(id).orElseThrow();
        descriptionsBootcamps.setDescription(detailDescriptions.getDescription());
        return descriptionsBootcampsRepository.save(descriptionsBootcamps);
    }

    public void deleteDescriptions(Long id) {
        descriptionsBootcampsRepository.deleteById(id);
    }
}
