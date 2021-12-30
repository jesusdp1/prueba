package com.prueba.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

	
	@Query( value = "SELECT * FROM USUARIO u WHERE u.EMAIL = ?1", 
			  nativeQuery = true)
	Usuario findUsuarioPorCorreo(String email);
}
