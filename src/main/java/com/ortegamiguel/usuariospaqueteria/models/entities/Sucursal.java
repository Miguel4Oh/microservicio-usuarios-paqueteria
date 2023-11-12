package com.ortegamiguel.usuariospaqueteria.models.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "SUCURSALES")
public class Sucursal {

    @Id
    @Column(name = "SUCURSAL_ID")
    private int sucursalId;

    @Column(name = "NOMBRE_SUCURSAL")
    private String nombreSucursal;
}
