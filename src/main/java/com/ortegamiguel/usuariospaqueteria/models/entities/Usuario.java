package com.ortegamiguel.usuariospaqueteria.models.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @NotNull
    @Id
    @Column(name = "USUARIO_ID")
    private Integer usuarioId;

    @NotEmpty
    @Column(name = "NOMBRE")
    private String nombre;

    @NotEmpty
    @Column(name = "CONTRASENA")
    private String contrasena;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "SUCURSAL_ID")
    private Sucursal sucursal;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ROL_ID")
    private Rol rol;
}
