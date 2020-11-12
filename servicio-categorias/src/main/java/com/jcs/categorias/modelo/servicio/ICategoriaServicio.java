package com.jcs.categorias.modelo.servicio;

import java.util.List;

import com.jcs.categorias.modelo.entity.Categoria;


public interface ICategoriaServicio {
	
	public List<Categoria> findAll();

	public Categoria findById(Long id);

	public Categoria save(Categoria categoria);

	public Categoria deleteById(Long id);

}
