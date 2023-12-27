package com.ortegamiguel.usuariospaqueteria.models.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "ROLES")
public class Rol {

    @Id
    @Column(name = "ROL_ID")
    private Integer rolId;

    @Column(name = "NOMBRE_ROL")
    private String nombreRol;
}
