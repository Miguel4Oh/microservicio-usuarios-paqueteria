package com.ortegamiguel.usuariospaqueteria.models.mapper;

import com.ortegamiguel.usuariospaqueteria.models.dto.RolDTO;
import com.ortegamiguel.usuariospaqueteria.models.entities.Rol;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolDTO rolToRolDto(Rol rol);

    Rol rolDtoToRol(RolDTO rolDTO);

    List<RolDTO> rolToRolDtoList(List<Rol> roles);

    List<Rol> rolDtoListToRoles(List<RolDTO> rolDTOList);
}
