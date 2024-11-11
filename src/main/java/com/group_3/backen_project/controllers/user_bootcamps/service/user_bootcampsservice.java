package com.group_3.backen_project.controllers.user_bootcamps.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.group_3.backen_project.models.Bootcamps;
import com.group_3.backen_project.models.User_bootcamps;
import com.group_3.backen_project.models.Users;
import com.group_3.backen_project.repositories.BootcampsRepository;
import com.group_3.backen_project.repositories.UserBootcampsRepository;
import com.group_3.backen_project.repositories.UserRepository;

@Service
public class User_bootcampsservice {
    private UserBootcampsRepository  userBootcampsRepository;
    private UserRepository userRepository;
    private BootcampsRepository bootcampsRepository;

    public User_bootcampsservice(
        UserBootcampsRepository userBootcampsRepository, 
        UserRepository userRepository,
        BootcampsRepository bootcampsRepository
        ) {
        this.userBootcampsRepository = userBootcampsRepository;
        this.userRepository = userRepository;
        this.bootcampsRepository = bootcampsRepository;
    }

    public User_bootcamps createUserBootcamps(Long idUser, Long idBootcamps) {

        Users users = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Id user not found"));

        Bootcamps bootcamps = bootcampsRepository.findById(idBootcamps)
                .orElseThrow(() -> new RuntimeException("id Bootcamp not found"));

        User_bootcamps userBootcamps = new User_bootcamps();
        userBootcamps.setIdUsuario(users);
        userBootcamps.setIdBootcamp(bootcamps);

        return userBootcampsRepository.save(userBootcamps);
    }

    public List<User_bootcamps> getalllUserBootcamps() {
        return userBootcampsRepository.findAll();
    }

    public Optional<User_bootcamps> getByIdUserBootcamps(Long id) {
        return userBootcampsRepository.findById(id);
    }

    public User_bootcamps updateUserBootcamps(
            Long id,
            Long idUser,
            Long idBootcamps) {
        User_bootcamps userBootcamps = userBootcampsRepository.findById(id).orElseThrow();

        Users users = userRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Id user not found"));

        Bootcamps bootcamps = bootcampsRepository.findById(idBootcamps)
                .orElseThrow(() -> new RuntimeException("id Bootcamp not found"));

        userBootcamps.setIdUsuario(users);
        userBootcamps.setIdBootcamp(bootcamps);
        
        return userBootcampsRepository.save(userBootcamps);
    }

    public void deleteUserBootcamp(Long id) {
        userBootcampsRepository.deleteById(id);
    }
}
