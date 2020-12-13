package com.obrasgrises.demo.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.obrasgrises.demo.MODEL.Obra;

public class ObraRM implements RowMapper<Obra> {

	@Override
	public Obra mapRow(ResultSet rs, int rowNum) throws SQLException {
		Obra obra = new Obra ();
		obra.setIdobra(rs.getInt("idobra"));
		obra.setNombre_obra(rs.getString("nombre_obra"));
		obra.setDescripcion(rs.getString("descripcion"));
		obra.setEstado(rs.getString("estado"));
		obra.setMunicipio(rs.getString("municipio"));
		obra.setImagenPath(rs.getString("imagen"));
		obra.setFoto_ubicacion_path(rs.getString("foto_ubicacion"));
		return obra;
	}

}
