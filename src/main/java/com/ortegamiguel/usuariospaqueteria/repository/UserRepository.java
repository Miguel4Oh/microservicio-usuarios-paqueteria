package com.ortegamiguel.usuariospaqueteria.repository;

import com.ortegamiguel.usuariospaqueteria.models.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
