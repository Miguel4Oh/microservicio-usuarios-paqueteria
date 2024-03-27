package com.ortegamiguel.usuariospaqueteria.service;

import com.ortegamiguel.usuariospaqueteria.models.dto.UserDTO;
import com.ortegamiguel.usuariospaqueteria.models.entities.UserEntity;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<UserDTO> listUsers();

    Map<String, Object> saveNewUser(UserEntity user, Authentication authentication);

    Map<String, Object> updateUser(UserEntity userEntity);

    Map<String, Object> deleteUser(String userId);
}
