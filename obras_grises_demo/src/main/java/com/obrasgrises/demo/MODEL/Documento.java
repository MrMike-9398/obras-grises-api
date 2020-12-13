package com.obrasgrises.demo.MODEL;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Documento {
	private int iddocumento;
	private String path;
	private String nombre_documento;
	private int obra_idobra;
}
