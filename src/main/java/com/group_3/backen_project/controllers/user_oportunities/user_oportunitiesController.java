package com.group_3.backen_project.controllers.user_oportunities;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group_3.backen_project.controllers.user_oportunities.service.User_oportunitiesservice;
import com.group_3.backen_project.models.User_oportunities;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/user-opportunity")
public class User_oportunitiesController {

    @Autowired
    private User_oportunitiesservice userOportunitiesService;

    @PostMapping("/{idUser}/{idOpportunity}")
    public ResponseEntity<User_oportunities> postUserOpportunity(@PathVariable Long idUser,
            @PathVariable Long idOpportunity) {
        return ResponseEntity.ok(userOportunitiesService.createUserOportunities(idUser, idOpportunity));
    }

    @GetMapping
    public List<User_oportunities> getUserOpportunities() {
        return userOportunitiesService.getalllUserOportunities();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User_oportunities> getUserOpportunity(@PathVariable Long id) {
        Optional<User_oportunities> userOpportunity = userOportunitiesService.getByIdUserOpportunities(id);
        return userOpportunity.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/{idUser}/{idOpportunity}")
    public ResponseEntity<User_oportunities> putUserOpportunity(
            @PathVariable Long id,
            @PathVariable Long idUser,
            @PathVariable Long idOpportunity) {

        return ResponseEntity.ok(userOportunitiesService.updateUserOportunities(id, idUser, idOpportunity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserOpportunity(@PathVariable Long id){
        userOportunitiesService.deleteUserOpportunities(id);
        return ResponseEntity.noContent().build();
    }

}
