package com.group_3.backen_project.controllers.users.services;

import com.group_3.backen_project.models.Role;
import com.group_3.backen_project.models.Users;
import com.group_3.backen_project.repositories.RoleRepository;
import com.group_3.backen_project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Configuration
@Service
public class UsersService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private RoleRepository roleRepository;

    @SuppressWarnings("null")
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users = userRepository.findByEmail(email);
        if(users == null){
            System.out.println("User not Found");
        }
        return new User(
            users.getEmail(),
            users.getPassword(),
                getAuthorities(users));
    }
    

    private Collection<? extends GrantedAuthority> getAuthorities(Users users) {
        return users.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_"+
        role.getName())).collect(Collectors.toList());
    }


    public Users createUser(Users users){
        users.setPassword(passwordEncoder().encode(users.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("USERS"));
        users.setRoles(roles);
        return userRepository.save(users);
    }

    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users updateUser(Long id,Long idRole, Users userDetails) {

        Role role = roleRepository.findById(idRole)
            .orElseThrow(() -> new RuntimeException("id Role not found"));

        Users user = userRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setLastName(userDetails.getLastName());
        user.setDateBirth(userDetails.getDateBirth());
        user.setEmail(userDetails.getEmail());
        user.setPassword(passwordEncoder().encode(userDetails.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Users getByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
