package com.ortegamiguel.usuariospaqueteria.models.dto;

import com.ortegamiguel.usuariospaqueteria.models.entities.UserEntity;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UserDTO {
    private String userId;
    private String userName;
    private BranchDTO branch;
    private RoleDTO role;

    public static UserDTO UserToUserDTO(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();
        BranchDTO branchDTO = new BranchDTO();
        RoleDTO roleDTO = new RoleDTO();

        branchDTO.setBranchName(userEntity.getBranch().getBranchName());
        roleDTO.setRoleName(userEntity.getRole().getRoleName());

        userDTO.setUserName(userEntity.getUserName());
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setBranch(branchDTO);
        userDTO.setRole(roleDTO);

        return userDTO;
    }
}
