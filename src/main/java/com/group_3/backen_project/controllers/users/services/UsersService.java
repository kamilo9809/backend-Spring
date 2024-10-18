package com.group_3.backen_project.controllers.users.services;

import com.group_3.backen_project.models.Users;
import com.group_3.backen_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;

    public Users createUser(Users user){
        return userRepository.save(user);
    }

    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users updateUser(Long id, Users userDetails) {
        Users user = userRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setLastName(userDetails.getLastName());
        user.setDateBirth(userDetails.getDateBirth());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRol(userDetails.getRol());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
