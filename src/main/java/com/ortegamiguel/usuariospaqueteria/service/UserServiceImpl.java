package com.ortegamiguel.usuariospaqueteria.service;

import com.ortegamiguel.usuariospaqueteria.models.dto.UserDTO;
import com.ortegamiguel.usuariospaqueteria.models.entities.UserEntity;
import com.ortegamiguel.usuariospaqueteria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class
UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> listUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserDTO> finalList = new ArrayList<>();

        for (UserEntity userEntity : users) {
            finalList.add(UserDTO.UserToUserDTO(userEntity));
        }

        return finalList;
    }

    @Override
    public Map<String, Object> saveNewUser(UserEntity userEntity, Authentication authentication) {
        Map<String, Object> response = new HashMap<>();
        String userRole = String.valueOf(authentication.getAuthorities().iterator().next());

        if (userRepository.findById(userEntity.getUserId()).isPresent()) {
            response.put("error", "El usuario ya se encuentra registrado");
            return response;

        }

        if(userEntity.getRole().getRoleId() != 5){
            if (!userRole.equals("ROLE_GERENTE") && !userRole.equals("ROLE_COORDINADOR")){
                response.put("error", "No tiene los permisos suficientes");
                return response;
            }
        }

        response.put("entity", saveUser(userEntity));
        return response;
    }

    @Override
    public Map<String, Object> updateUser(UserEntity userEntity){
        Map<String, Object> response = new HashMap<>();
        Optional<UserEntity> registeredUser = userRepository.findById(userEntity.getUserId());

        if(!registeredUser.isPresent()){
            response.put("error", "No se encontró al usurario");
            return response;
        }

        userRepository.save(userEntity);

        return response;
    }

    @Override
    public Map<String, Object> deleteUser(String userId){
        Map<String, Object> response = new HashMap<>();
        Optional<UserEntity> registeredUser = userRepository.findById(userId);

        System.out.println(userId);

        if(!registeredUser.isPresent()){
            response.put("error", "El usuario no esta registrado");
            return response;
        }

        userRepository.delete(registeredUser.orElseThrow());

        return response;
    }

    private UserEntity saveUser(UserEntity userEntity) {
        userEntity.setUserPassword(passwordEncoder.encode(userEntity.getUserPassword()));
        return userRepository.save(userEntity);
    }

}
