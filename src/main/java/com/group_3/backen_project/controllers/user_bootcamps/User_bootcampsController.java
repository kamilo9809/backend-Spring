package com.group_3.backen_project.controllers.user_bootcamps;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group_3.backen_project.controllers.user_bootcamps.service.User_bootcampsservice;
import com.group_3.backen_project.models.User_bootcamps;

@RestController
@RequestMapping("api/user-bootcamp")
public class User_bootcampsController {
    private User_bootcampsservice userBootcampsService;

     @PostMapping("/{idUser}/{idBootcamps}")
    public ResponseEntity<User_bootcamps> postUserBootcamps(@PathVariable Long idUser,
            @PathVariable Long idBootcamps) {
        return ResponseEntity.ok(userBootcampsService.createUserBootcamps(idUser, idBootcamps));
    }

    @GetMapping
    public List<User_bootcamps> getUserBootcamps() {
        return userBootcampsService.getalllUserBootcamps();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User_bootcamps> getUserBootcamps(@PathVariable Long id) {
        Optional<User_bootcamps> userBootcamps = userBootcampsService.getByIdUserBootcamps(id);
        return userBootcamps.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/{idUser}/{idBootcamps}")
    public ResponseEntity<User_bootcamps> putUserBootcamps(
            @PathVariable Long id,
            @PathVariable Long idUser,
            @PathVariable Long idBootcamps) {

        return ResponseEntity.ok(userBootcampsService.updateUserBootcamps(id, idUser, idBootcamps));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserBootcamps(@PathVariable Long id){
        userBootcampsService.deleteUserBootcamp(id);
        return ResponseEntity.noContent().build();
    }

}
