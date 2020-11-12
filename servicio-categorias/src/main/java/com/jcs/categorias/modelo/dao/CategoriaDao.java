package com.jcs.categorias.modelo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcs.categorias.modelo.entity.Categoria;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {

	public Categoria findByIdAndStatus(Long id, Boolean status);

	public List<Categoria> findAllByStatus(Boolean status);

}
