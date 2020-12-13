package com.obrasgrises.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.obrasgrises.demo.MODEL.Usuario;


public class UsuarioRM implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario user = new Usuario();
		user.setIdusuario(rs.getInt("idusuario"));
		user.setNombre_usuario(rs.getString("nombre_usuario"));
		user.setPassWord(rs.getString("passWord"));
		return user;
	}

}
