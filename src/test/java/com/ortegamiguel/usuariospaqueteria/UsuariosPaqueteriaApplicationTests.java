package com.ortegamiguel.usuariospaqueteria;

import com.ortegamiguel.usuariospaqueteria.models.dto.UserDTO;
import com.ortegamiguel.usuariospaqueteria.models.entities.BranchEntity;
import com.ortegamiguel.usuariospaqueteria.models.entities.RoleEntity;
import com.ortegamiguel.usuariospaqueteria.models.entities.UserEntity;
import com.ortegamiguel.usuariospaqueteria.repository.UserRepository;
import com.ortegamiguel.usuariospaqueteria.service.UserServiceImpl;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UsuariosPaqueteriaApplicationTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private UserEntity userEntity;

    @BeforeEach
    void setUp(){
        userEntity = new UserEntity();
        userEntity.setUserName("Miguel");
        userEntity.setUserPassword("abcd");
        userEntity.setUserId("1234");
        userEntity.setBranch(new BranchEntity());
        userEntity.setRole(new RoleEntity());
    }

    @Test
    void test1() {
        List<UserEntity> userEntityList = new ArrayList<>();
        userEntityList.add(userEntity);

        Mockito.when(userRepository.findAll()).thenReturn(userEntityList);

        List<UserDTO> userDTOS = userService.listUsers();

        Assert.notNull(userDTOS);
    }

}
