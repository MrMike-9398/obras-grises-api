package com.obrasgrises.demo.DAO;

import com.obrasgrises.demo.MODEL.Usuario;

public interface UsuarioDAO {

	boolean login(Usuario user);

	Usuario obtenerUsuario(String user);

}
