package com.barbershop.api.repository;

import com.barbershop.api.domain.entity.Usuario;
import com.barbershop.api.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Usuario> findByRoleAndAtivoTrue(Role role);
}
