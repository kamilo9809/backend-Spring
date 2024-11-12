package com.group_3.backen_project.controllers.institute_oportunities.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Institute_opportunities;
import com.group_3.backen_project.models.Institutions;
import com.group_3.backen_project.models.Opportunities;
import com.group_3.backen_project.repositories.InstituteOpportunitiesRepository;
import com.group_3.backen_project.repositories.InstitutionsRepository;
import com.group_3.backen_project.repositories.OpportunitiesRepository;

@Service
public class Institute_oportunitiesservice {
        private InstituteOpportunitiesRepository instituteOpportunitiesRepository;
        private InstitutionsRepository institutionsRepository;
        private OpportunitiesRepository opportunitiesRepository;
        
        public Institute_oportunitiesservice(
            InstituteOpportunitiesRepository instituteOpportunitiesRepository,
            InstitutionsRepository institutionsRepository, 
            OpportunitiesRepository opportunitiesRepository
            ) {
            this.instituteOpportunitiesRepository = instituteOpportunitiesRepository;
            this.institutionsRepository = institutionsRepository;
            this.opportunitiesRepository = opportunitiesRepository;
        }

         public Institute_opportunities createInstitutionsOpp(Long idInstitute, Long idOpportunity) {

        Institutions institutions = institutionsRepository.findById(idInstitute)
                .orElseThrow(() -> new RuntimeException("Id institute not found"));

        Opportunities opportunities = opportunitiesRepository.findById(idOpportunity)
                .orElseThrow(() -> new RuntimeException("id opportunity not found"));

        Institute_opportunities instituteOpportunity = new Institute_opportunities();
        instituteOpportunity.setInstitutions(institutions);
        instituteOpportunity.setOpportunities(opportunities);


        return instituteOpportunitiesRepository.save(instituteOpportunity);
    }

    public List<Institute_opportunities> getalllInstituteOportunities() {
        return instituteOpportunitiesRepository.findAll();
    }

    public Optional<Institute_opportunities> getByIdInstituteOpportunities(Long id) {
        return instituteOpportunitiesRepository.findById(id);
    }

    public Institute_opportunities updateinstituteOportunities(
            Long id,
            Long idInstitute,
            Long idOpportunity) {
        Institute_opportunities instituteOppOportunities = instituteOpportunitiesRepository.findById(id).orElseThrow();

        Institutions institutions = institutionsRepository.findById(idInstitute)
                .orElseThrow(() -> new RuntimeException("Id user not found"));

        Opportunities opportunities = opportunitiesRepository.findById(idOpportunity)
                .orElseThrow(() -> new RuntimeException("id opportunity not found"));

                instituteOppOportunities.setInstitutions(institutions);
                instituteOppOportunities.setOpportunities(opportunities);

        return instituteOpportunitiesRepository.save(instituteOppOportunities);
    }

    public void deleteInstitutionsOpportunities(Long id) {
        instituteOpportunitiesRepository.deleteById(id);
    }

        
    
    
}
