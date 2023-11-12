package com.ortegamiguel.usuariospaqueteria.models.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @Column(name = "USUARIO_ID")
    private int usuarioId;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "CONTRASENA")
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "SUCURSAL_ID")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "ROL_ID")
    private Rol rol;
}
