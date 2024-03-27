package com.ortegamiguel.usuariospaqueteria.service;

import com.ortegamiguel.usuariospaqueteria.models.entities.UserEntity;
import com.ortegamiguel.usuariospaqueteria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findById(username);
        
        if(!user.isPresent()){
            throw new UsernameNotFoundException("El usuario no existe");
        }

        UserEntity foundedUser = user.orElseThrow();

        List<GrantedAuthority> roles = Arrays.asList(new SimpleGrantedAuthority(foundedUser.getRole().getRoleName()));

        return new User(String.valueOf(foundedUser.getUserId()), foundedUser.getUserPassword(), true,
                true, true, true, roles);
    }
}
