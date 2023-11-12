package com.ortegamiguel.usuariospaqueteria.models.mapper;

import com.ortegamiguel.usuariospaqueteria.models.dto.UsuarioDTO;
import com.ortegamiguel.usuariospaqueteria.models.entities.Usuario;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SucursalMapper.class, RolMapper.class})
public interface UsuarioMapper {

    @Mapping(target = "usuarioId", source = "usuarioId")
    @Mapping(target = "nombre", source = "nombre")
    UsuarioDTO usuarioToUsuarioDto(Usuario usuario);

    @InheritInverseConfiguration
    Usuario usuarioDtoToUsuario(UsuarioDTO usuarioDTO);

    List<UsuarioDTO> usuarioToUsuarioDtoList(List<Usuario> usuarios);

    List<Usuario> usuarioDtoListToUsuarios(List<UsuarioDTO> usuarioDTOList);
}
