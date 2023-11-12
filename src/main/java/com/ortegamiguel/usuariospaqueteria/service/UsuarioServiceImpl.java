package com.ortegamiguel.usuariospaqueteria.service;

import com.ortegamiguel.usuariospaqueteria.models.dto.UsuarioDTO;
import com.ortegamiguel.usuariospaqueteria.models.entities.Usuario;
import com.ortegamiguel.usuariospaqueteria.models.mapper.UsuarioMapper;
import com.ortegamiguel.usuariospaqueteria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioMapper.usuarioToUsuarioDtoList(usuarioRepository.findAll());
    }
}
