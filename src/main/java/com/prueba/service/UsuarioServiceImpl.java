package com.prueba.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.model.Request;
import com.prueba.model.Usuario;
import com.prueba.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	UsuarioRepository repository;

	@Override
	public Usuario resgitrarUsuario(Request request) {
		Usuario usuario = new Usuario();
		// TODO Auto-generated method stub
		usuario.setName(request.getName());
		usuario.setEmail(request.getEmail());
		usuario.setPassword(request.getPassword());
		usuario.setPhones(request.getPhones());
		usuario.setCreated(new Date());
		usuario.setModified(new Date());
		usuario.setId(UUID.randomUUID());
		usuario.setActive(true);
		usuario.setLastLogin(usuario.getCreated());
		usuario.setToken(UUID.randomUUID());
		usuario = repository.save(usuario);
		
		return usuario;
	}

	@Override
	public List<Usuario> getListUsuarios() {

		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Usuario findUsuarioPorCorreo(String email) {
		// TODO Auto-generated method stub
		return repository.findUsuarioPorCorreo(email);
	}

}
