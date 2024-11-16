package com.group_3.backen_project.controllers.auth;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group_3.backen_project.controllers.users.services.UsersService;
import com.group_3.backen_project.dto.UserAuth;
import com.group_3.backen_project.jwt.JwtTokenProvider;
import com.group_3.backen_project.models.Users;

@RestController
@RequestMapping("api/auth")
public class Auth {
    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;
    private UsersService usersService;
    
    public Auth(
        AuthenticationManager authenticationManager, 
        JwtTokenProvider jwtTokenProvider,
        UsersService usersService
        ) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.usersService = usersService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticate(@RequestBody UserAuth userAuth){
        System.out.println("ingresando a authenticate");
        System.out.println(userAuth);
        try {

            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userAuth.getEmail(),userAuth.getPassword())
            );

            String token = jwtTokenProvider.generateToken(authentication);

            Users users = usersService.getByEmail(userAuth.getEmail());

            System.out.println("se ha autenticado con exito");
            return ResponseEntity.ok().body(Map.of("token",token,"role",users.getRoles()));
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        } catch (BadCredentialsException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        } catch (Exception e){
            System.out.println(e);
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Authentication failed");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users users){
        usersService.createUser(users);
        return ResponseEntity.ok("User register succesfully");
    }
}
