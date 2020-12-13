package com.obrasgrises.demo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.obrasgrises.demo.MODEL.Usuario;


@Repository
public class UsusarioJDBC implements UsuarioDAO {

	@Autowired
	JdbcTemplate template;

	@Override
	public boolean login(Usuario user) {

		String sql = " SELECT * FROM usuario WHERE nombre_usuario = ? LIMIT 1";

		List<Usuario> userfinded = template.query(sql, new UsuarioRM(), user.getNombre_usuario());

		if (!userfinded.isEmpty()) {
			if (userfinded.get(0).getPassWord().equals(user.getPassWord())) {
				return true;
			}
		} 
			return false;

	}

	@Override
	public Usuario obtenerUsuario(String user) {

		String sql = " SELECT * FROM usuario WHERE nombre_usuario = ? ";
		
		return template.queryForObject(sql, new UsuarioRM(), user);
	}

}
