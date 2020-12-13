package com.obrasgrises.demo.SERVICES;

import java.util.List;

import com.obrasgrises.demo.MODEL.Obra;

public interface ObraService {

	List<Obra> listObra();

	void crearObra(Obra obra);

}
