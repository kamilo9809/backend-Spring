package com.group_3.backen_project.controllers.user_oportunities.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Opportunities;
import com.group_3.backen_project.models.User_oportunities;
import com.group_3.backen_project.models.Users;
import com.group_3.backen_project.repositories.OpportunitiesRepository;
import com.group_3.backen_project.repositories.UserOpportunitiesRepository;
import com.group_3.backen_project.repositories.UserRepository;

@Service
public class User_oportunitiesservice {
    private UserOpportunitiesRepository userOpportunitiesRepository;
    private UserRepository userRepository;
    private OpportunitiesRepository opportunitiesRepository;

    public User_oportunitiesservice(
            UserOpportunitiesRepository userOpportunitiesRepository,
            UserRepository userRepository,
            OpportunitiesRepository opportunitiesRepository) {
        this.userOpportunitiesRepository = userOpportunitiesRepository;
        this.userRepository = userRepository;
        this.opportunitiesRepository = opportunitiesRepository;
    }

    public User_oportunities createUserOportunities(Long idUser, Long idOpportunity) {

        Users users = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Id user not found"));

        Opportunities opportunities = opportunitiesRepository.findById(idOpportunity)
                .orElseThrow(() -> new RuntimeException("id opportunity not found"));

        User_oportunities userOpportunity = new User_oportunities();
        userOpportunity.setUsers(users);
        userOpportunity.setOpportunities(opportunities);

        return userOpportunitiesRepository.save(userOpportunity);
    }

    public List<User_oportunities> getalllUserOportunities() {
        return userOpportunitiesRepository.findAll();
    }

    public Optional<User_oportunities> getByIdUserOpportunities(Long id) {
        return userOpportunitiesRepository.findById(id);
    }

    public User_oportunities updateUserOportunities(
            Long id,
            Long idUser,
            Long idOpportunity) {
        User_oportunities userOppOportunities = userOpportunitiesRepository.findById(id).orElseThrow();

        Users users = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Id user not found"));

        Opportunities opportunities = opportunitiesRepository.findById(idOpportunity)
                .orElseThrow(() -> new RuntimeException("id opportunity not found"));

        userOppOportunities.setUsers(users);
        userOppOportunities.setOpportunities(opportunities);

        return userOpportunitiesRepository.save(userOppOportunities);
    }

    public void deleteUserOpportunities(Long id) {
        userOpportunitiesRepository.deleteById(id);
    }

}
