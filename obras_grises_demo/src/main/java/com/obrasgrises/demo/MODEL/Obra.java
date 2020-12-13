package com.obrasgrises.demo.MODEL;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Obra {
	private int idobra;
	private String nombre_obra;
	private String descripcion;
	private String imagenPath;
	private String estado;
	private String municipio;
	private String foto_ubicacion_path;
	private List<Documento> docs;
}
