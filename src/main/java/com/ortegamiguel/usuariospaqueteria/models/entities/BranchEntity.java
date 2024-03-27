package com.ortegamiguel.usuariospaqueteria.models.entities;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "BRANCHES")
public class BranchEntity {

    @Id
    @Column(name = "BRANCH_ID")
    private Integer branchId;

    @Column(name = "BRANCH_NAME")
    private String branchName;

}
