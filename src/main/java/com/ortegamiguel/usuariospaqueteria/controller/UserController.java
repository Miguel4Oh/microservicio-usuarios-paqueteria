package com.ortegamiguel.usuariospaqueteria.controller;

import com.ortegamiguel.usuariospaqueteria.models.dto.UserDTO;
import com.ortegamiguel.usuariospaqueteria.models.entities.UserEntity;
import com.ortegamiguel.usuariospaqueteria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/paqueteria/v0/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        List<UserDTO> users = userService.listUsers();

        if(users.isEmpty())
            ResponseEntity.noContent().build();

        return ResponseEntity.ok(users);
    }

    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody UserEntity newUser, Authentication authentication){

        Map<String, Object> response = userService.saveNewUser(newUser, authentication);

        if(response.containsKey("error")){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response.get("error"));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("El usuario se ha creado exitosamente");
    }

    @PatchMapping("/user")
    public ResponseEntity<?> updateUser(UserEntity userEntity){
        Map<String, Object> response = userService.updateUser(userEntity);

        if(response.containsKey("error")){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response.get("error"));
        }
        return ResponseEntity.status(HttpStatus.OK).body("Usurio actualizado correctamente");
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId){
        Map<String, Object> response = userService.deleteUser(userId);

        if (response.containsKey("error")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response.get("error"));
        }

        return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado correctamente");
    }

}