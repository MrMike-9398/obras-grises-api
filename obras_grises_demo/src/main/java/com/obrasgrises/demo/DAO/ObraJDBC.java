package com.obrasgrises.demo.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.obrasgrises.demo.MODEL.Obra;

@Repository
public class ObraJDBC implements ObraDao {
	
	@Autowired
	JdbcTemplate jdbctemplate;

	@Override
	public List<Obra> listObra() {
		String sqlQuery = " SELECT * FROM obra ";
		
		return jdbctemplate.query(sqlQuery, new ObraRM());
	}

	@Override
	public void crearObra(Obra obra) {
		String insertquery = " INSERT INTO obra( nombre_obra, descripcion, imagen, estado, municipio, foto_ubicacion) VALUES(?,?,?,?,?,?) ";
		jdbctemplate.update(insertquery,obra.getNombre_obra(),obra.getDescripcion(),obra.getImagenPath(), obra.getEstado(),obra.getMunicipio(), obra.getFoto_ubicacion_path());
	}

}
