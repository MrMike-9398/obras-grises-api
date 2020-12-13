package com.obrasgrises.demo.SERVICES;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obrasgrises.demo.DAO.ObraDao;
import com.obrasgrises.demo.MODEL.Obra;


@Service
public class ObraLogica implements ObraService {
	
	@Autowired
	ObraDao obradao;

	@Override
	public List<Obra> listObra() {
		return obradao.listObra();
	}

	@Override
	public void crearObra(Obra obra) {
		obradao.crearObra(obra);
	}
	
}
