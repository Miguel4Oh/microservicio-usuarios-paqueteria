package com.ortegamiguel.usuariospaqueteria.service;

import com.ortegamiguel.usuariospaqueteria.models.dto.UsuarioDTO;
import com.ortegamiguel.usuariospaqueteria.models.mapper.UsuarioMapper;
import com.ortegamiguel.usuariospaqueteria.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioMapper.usuarioToUsuarioDtoList(usuarioRepository.findAll());
    }
}
