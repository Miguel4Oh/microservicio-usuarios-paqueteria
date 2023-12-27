package com.ortegamiguel.usuariospaqueteria.controller;

import com.ortegamiguel.usuariospaqueteria.models.dto.UsuarioDTO;
import com.ortegamiguel.usuariospaqueteria.models.entities.Usuario;
import com.ortegamiguel.usuariospaqueteria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paqueteria/v0/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<?> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.obtenerUsuarios();

        if(usuarios.isEmpty())
            ResponseEntity.noContent().build();

        return ResponseEntity.ok(usuarios);
    }

    @PostMapping("/usuario")
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody Usuario usuario, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            List<String> errors = new ArrayList<>();

            for(FieldError error: bindingResult.getFieldErrors()){
                errors.add("Campo: " + error.getField() + " " + error.getDefaultMessage());
            }

            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        UsuarioDTO nuevoUsuario = usuarioService.agregarUsuario(usuario);

        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }
}