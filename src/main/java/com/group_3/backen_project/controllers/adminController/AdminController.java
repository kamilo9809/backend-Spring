package com.group_3.backen_project.controllers.adminController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Admin")
public class AdminController {

    @GetMapping("/configuration")
    public ResponseEntity<String> getConfiguration(){
        return ResponseEntity.ok("Configuration admin");
    }
}
