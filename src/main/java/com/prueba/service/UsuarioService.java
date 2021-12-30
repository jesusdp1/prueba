package com.prueba.service;

import java.util.List;

import com.prueba.model.Request;
import com.prueba.model.Usuario;

public interface UsuarioService {
	
	public Usuario resgitrarUsuario(Request usuario);
	public List<Usuario> getListUsuarios();
	public Usuario findUsuarioPorCorreo(String email);

}
