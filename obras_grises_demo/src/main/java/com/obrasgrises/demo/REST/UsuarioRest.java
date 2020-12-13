package com.obrasgrises.demo.REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.obrasgrises.demo.MODEL.Respuesta;
import com.obrasgrises.demo.MODEL.Usuario;
import com.obrasgrises.demo.SERVICES.UsuarioService;



@RequestMapping("/usuario")
@RestController
public class UsuarioRest {
	
	@Autowired
	UsuarioService userSer;
	
	@PostMapping
	public ResponseEntity<Respuesta> login(@RequestBody Usuario user){
		Respuesta resp = new Respuesta();
		boolean logged = false;
		try {
			logged = userSer.login(user);
			resp.setEstatus("OK");
			resp.setObject(logged);
			resp.setMensaje("Peticion Inicio de Sesión Exitosa");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Inicio de Sesión Fallido");
			return new ResponseEntity<Respuesta>(resp,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Respuesta>(resp,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Respuesta> getUser(@RequestParam String user){
		Respuesta resp = new Respuesta();
		Usuario usuario = new Usuario();
		try {
			usuario = userSer.obtenerUsuario(user);
			resp.setObject(usuario);
			resp.setEstatus("OK");
			resp.setMensaje("Usuario recuperado con exito");
		} catch (Exception e) {
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Error al recuperar el usuario");
			return new ResponseEntity<Respuesta>(resp,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Respuesta>(resp,HttpStatus.OK);
	}
}