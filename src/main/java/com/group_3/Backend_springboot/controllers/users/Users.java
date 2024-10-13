package com.group_3.Backend_springboot.controllers.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Users {

    @GetMapping("/users")
    public String saludo(){
        return "Hola mundo";
    }
}
