package com.ortegamiguel.usuariospaqueteria.repository;

import com.ortegamiguel.usuariospaqueteria.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
