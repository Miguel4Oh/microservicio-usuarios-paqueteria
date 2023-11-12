package com.ortegamiguel.usuariospaqueteria.models.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ROLES")
public class Rol {

    @Id
    @Column(name = "ROL_ID")
    private int rolId;

    @Column(name = "NOMBRE_ROL")
    private String nombreRol;
}
