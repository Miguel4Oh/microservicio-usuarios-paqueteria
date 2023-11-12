package com.ortegamiguel.usuariospaqueteria.models.mapper;

import com.ortegamiguel.usuariospaqueteria.models.dto.SucursalDTO;
import com.ortegamiguel.usuariospaqueteria.models.entities.Sucursal;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SucursalMapper {

    SucursalDTO sucursalToSucursalDto(Sucursal sucursal);

    Sucursal sucursalDtoToSucursal(SucursalDTO sucursalDTO);

    List<SucursalDTO> sucursalToSucursalDtoList(List<Sucursal> sucursales);

    List<Sucursal> sucursalDtoListToSucursales(List<SucursalDTO> sucursalDTOList);
}
