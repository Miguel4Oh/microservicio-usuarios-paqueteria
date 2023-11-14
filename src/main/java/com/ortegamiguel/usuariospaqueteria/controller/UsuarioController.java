package com.ortegamiguel.usuariospaqueteria.controller;

import com.ortegamiguel.usuariospaqueteria.models.dto.UsuarioDTO;
import com.ortegamiguel.usuariospaqueteria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paqueteria/v0/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar-usuarios")
    public ResponseEntity<?> listarUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.obtenerUsuarios();

        if(usuarios.isEmpty())
            ResponseEntity.noContent().build();

        return ResponseEntity.ok(usuarios);
    }
}