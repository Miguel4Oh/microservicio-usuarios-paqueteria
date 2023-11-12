package com.ortegamiguel.usuariospaqueteria.models.dto;

import lombok.Data;


@Data
public class UsuarioDTO {
    private int usuarioId;
    private String nombre;
    private SucursalDTO sucursal;
    private RolDTO rol;
}
