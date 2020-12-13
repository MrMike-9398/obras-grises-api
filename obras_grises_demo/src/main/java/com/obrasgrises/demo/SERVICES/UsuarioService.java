package com.obrasgrises.demo.SERVICES;

import com.obrasgrises.demo.MODEL.Usuario;

public interface UsuarioService {

	boolean login(Usuario user);

	Usuario obtenerUsuario(String user);

}
