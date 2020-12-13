package com.obrasgrises.demo.REST;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.obrasgrises.demo.MODEL.Obra;
import com.obrasgrises.demo.MODEL.Respuesta;
import com.obrasgrises.demo.MODEL.Usuario;
import com.obrasgrises.demo.SERVICES.FileStorageService;
import com.obrasgrises.demo.SERVICES.ObraService;

@RequestMapping("/obra")
@RestController
public class ObraRest {

	@Autowired
	ObraService obraserv;

	@Autowired
	FileStorageService storageService;

	@GetMapping
	private ResponseEntity<Respuesta> listObras() {
		Respuesta resp = new Respuesta();
		List<Obra> obraList = new ArrayList<>();
		try {
			obraList = obraserv.listObra();
			resp.setEstatus("OK");
			resp.setObject(obraList);
			resp.setMensaje("Obras Recuperadas con exito");
		} catch (Exception e) {
			resp.setEstatus("Error");
			resp.setDescripcionError(e.getMessage());
			resp.setMensaje("Ocurrio un Error al Recuperar las Obras");
			return new ResponseEntity<Respuesta>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Respuesta>(resp, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Respuesta> createObra(@RequestBody Obra obra) {
		Respuesta resp = new Respuesta();
		try {
			obraserv.crearObra(obra);
			resp.setMensaje("Obra creada con exito");
			resp.setEstatus("OK");
		} catch (Exception e) {
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("A Ocurrido un error");
			return new ResponseEntity<Respuesta>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Respuesta>(resp, HttpStatus.OK);
	}

	@PostMapping("/upload")
	public ResponseEntity<Respuesta> uploadFile(@RequestParam MultipartFile file, @RequestParam Integer idobra) { 
		Respuesta resp = new Respuesta();
		try {
			System.out.println("Nombre de la Ob: " + idobra);
			storageService.save(file);
			resp.setMensaje("Uploaded the file successfully: " + file.getOriginalFilename());
			resp.setEstatus("OK");
		} catch (Exception e) {
			resp.setDescripcionError(e.getMessage());
			resp.setEstatus("ERROR");
			resp.setMensaje("Could not upload the file: " + file.getOriginalFilename() + "!");
			return new ResponseEntity<Respuesta>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Respuesta>(resp, HttpStatus.OK);
	}

}
