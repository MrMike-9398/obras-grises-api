package com.obrasgrises.demo.DAO;

import java.util.List;

import com.obrasgrises.demo.MODEL.Obra;

public interface ObraDao {

	List<Obra> listObra();

	void crearObra(Obra obra);

}
