package com.projetosestudos.primeiro_projeto_spring.controllers;

import com.projetosestudos.primeiro_projeto_spring.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User user = new User(1L, "Maria", "maria@gmail.com",
                "99999-8888", "12345");
        return ResponseEntity.ok().body(user);
    }
}
