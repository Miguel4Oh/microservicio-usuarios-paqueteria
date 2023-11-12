package com.ortegamiguel.usuariospaqueteria.controller;

import com.ortegamiguel.usuariospaqueteria.models.dto.UsuarioDTO;
import com.ortegamiguel.usuariospaqueteria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paqueteria/v0/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar-usuarios")
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioService.obtenerUsuarios();
    }
}
