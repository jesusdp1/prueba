package com.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.model.Mensaje;
import com.prueba.model.Request;
import com.prueba.model.Usuario;
import com.prueba.service.UsuarioService;
import com.prueba.util.Util;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@PostMapping(path = "/registro",  produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> registrar(@RequestBody Request request) {
		try {
			if(!Util.validadorEmail(request.getEmail())) {
				return new ResponseEntity<>(new Mensaje("El correo no tiene un formato valido"), HttpStatus.NOT_ACCEPTABLE);
				
			}
			
			if(!Util.validadorPassword(request.getPassword())) {
				return new ResponseEntity<>(new Mensaje("La Clave no cumple con el formato requerido"), HttpStatus.NOT_ACCEPTABLE);
				
			}
			Usuario usuario =  service.findUsuarioPorCorreo(request.getEmail());
			if(usuario != null) {
				return new ResponseEntity<>(new Mensaje("El correo que ingreso ya esta afiliado a otro usuario"), HttpStatus.NOT_FOUND);

			}
			return new ResponseEntity<>(service.resgitrarUsuario(request), HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(new Mensaje("Falla en la aplicacion"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(path = "/list-usuario",  produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getList() {
		try {
			List<Usuario> list = service.getListUsuarios();

			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(new Mensaje("No existen datos en la BD"), HttpStatus.NOT_ACCEPTABLE);
			}
			return new ResponseEntity<>(service.getListUsuarios(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new Mensaje("Falla en la aplicacion"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
