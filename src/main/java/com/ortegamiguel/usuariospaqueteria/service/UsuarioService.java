package com.ortegamiguel.usuariospaqueteria.service;

import com.ortegamiguel.usuariospaqueteria.models.dto.UsuarioDTO;
import com.ortegamiguel.usuariospaqueteria.models.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> obtenerUsuarios();

    UsuarioDTO agregarUsuario(Usuario usuario);
}
