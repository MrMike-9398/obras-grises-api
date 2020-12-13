package com.obrasgrises.demo.MODEL;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Usuario {
	private int idusuario;
	private String nombre_usuario;
	private String passWord;
}
