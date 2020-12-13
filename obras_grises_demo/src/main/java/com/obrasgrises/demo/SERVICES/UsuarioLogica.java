package com.obrasgrises.demo.SERVICES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obrasgrises.demo.DAO.UsuarioDAO;
import com.obrasgrises.demo.MODEL.Usuario;

@Service
public class UsuarioLogica implements UsuarioService {
	
	@Autowired
	UsuarioDAO userDao;

	@Override
	public boolean login(Usuario user) {
		return userDao.login(user);
	}

	@Override
	public Usuario obtenerUsuario(String user) {
		return userDao.obtenerUsuario(user);
	}

}
