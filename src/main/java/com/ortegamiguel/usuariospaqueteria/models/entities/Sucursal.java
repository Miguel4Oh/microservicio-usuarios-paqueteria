package com.ortegamiguel.usuariospaqueteria.models.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "SUCURSALES")
public class Sucursal {

    @Id
    @Column(name = "SUCURSAL_ID")
    private Integer sucursalId;

    @Column(name = "NOMBRE_SUCURSAL")
    private String nombreSucursal;

}
