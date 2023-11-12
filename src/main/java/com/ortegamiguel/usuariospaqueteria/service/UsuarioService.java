package com.ortegamiguel.usuariospaqueteria.service;

import com.ortegamiguel.usuariospaqueteria.models.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> obtenerUsuarios();
}
