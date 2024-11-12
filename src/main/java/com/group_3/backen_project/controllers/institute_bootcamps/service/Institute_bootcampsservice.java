package com.group_3.backen_project.controllers.institute_bootcamps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Bootcamps;
import com.group_3.backen_project.models.Institute_bootcamps;
import com.group_3.backen_project.models.Institutions;
import com.group_3.backen_project.repositories.BootcampsRepository;
import com.group_3.backen_project.repositories.InstituteBootcampsRepository;
import com.group_3.backen_project.repositories.InstitutionsRepository;

@Service
public class Institute_bootcampsservice {
    private InstitutionsRepository institutionsRepository;
    private BootcampsRepository bootcampsRepository;
    private InstituteBootcampsRepository instituteBootcampsRepository;
    
        public Institute_bootcampsservice(
            InstitutionsRepository institutionsRepository,
            BootcampsRepository bootcampsRepository, 
            InstituteBootcampsRepository instituteBootcampsRepository
            ) {
            this.institutionsRepository = institutionsRepository;
            this.bootcampsRepository = bootcampsRepository;
            this.instituteBootcampsRepository = instituteBootcampsRepository;
        }
    
         public Institute_bootcamps createInstitutionsBootcamps(Long idInstitute, Long idBootcamps) {
    
            Institutions institutions = institutionsRepository.findById(idInstitute)
                    .orElseThrow(() -> new RuntimeException("Id institute not found"));
    
            Bootcamps bootcamps = bootcampsRepository.findById(idBootcamps)
                    .orElseThrow(() -> new RuntimeException("id Bootcamp not found"));
    
            Institute_bootcamps instituteBootcamps = new Institute_bootcamps();
            instituteBootcamps.setInstitutions(institutions);
            instituteBootcamps.setBootcamps(bootcamps);
    
            return instituteBootcampsRepository.save(instituteBootcamps);
        }
    
        public List<Institute_bootcamps> getalllInstituteBootcamps() {
            return instituteBootcampsRepository.findAll();
    }

    public Optional<Institute_bootcamps> getByIdInstituteBootcamps(Long id) {
        return instituteBootcampsRepository.findById(id);
    }

    public Institute_bootcamps updateinstituteBootcamps(
            Long id,
            Long idInstitute,
            Long idBootcamps) {
        Institute_bootcamps instituteBootcamps = instituteBootcampsRepository.findById(id).orElseThrow();

        Institutions institutions = institutionsRepository.findById(idInstitute)
                .orElseThrow(() -> new RuntimeException("Id user not found"));

        Bootcamps bootcamps = bootcampsRepository.findById(idBootcamps)
                .orElseThrow(() -> new RuntimeException("id Bootcamp not found"));

                instituteBootcamps.setInstitutions(institutions);
                instituteBootcamps.setBootcamps(bootcamps);

        return instituteBootcampsRepository.save(instituteBootcamps);
    }

    public void deleteInstitutionsBootcamps(Long id) {
        instituteBootcampsRepository.deleteById(id);
    }

    
}
