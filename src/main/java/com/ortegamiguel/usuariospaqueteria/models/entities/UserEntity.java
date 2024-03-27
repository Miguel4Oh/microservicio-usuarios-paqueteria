package com.ortegamiguel.usuariospaqueteria.models.entities;

import lombok.Data;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "USERS")
public class UserEntity {

    @NotEmpty
    @NotNull
    @Id
    @Column(name = "USER_ID")
    private String userId;

    @NotEmpty
    @NotNull
    @Column(name = "USER_NAME")
    private String userName;

    @NotEmpty
    @NotNull
    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "BRANCH_ID")
    private BranchEntity branch;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private RoleEntity role;
}
