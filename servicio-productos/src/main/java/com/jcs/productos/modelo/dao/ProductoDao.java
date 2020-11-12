package com.jcs.productos.modelo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcs.productos.modelo.entity.Producto;

import java.util.List;

public interface ProductoDao extends JpaRepository<Producto, Long>{
	
	public Producto findByIdAndStatus(Long id, Boolean status);
	
	public List<Producto> findAllByStatus(Boolean status);
	
}


/*
 * ACA DA ERROR AL PONER DOBLE EL QUERY CAMBIAR EL NOMBRE DEL METODO PARA QUE NO AFECTE
 * 
 * @Query("select u from Productos u where u.id = ?1 and u.estado = ?2")
	public Producto findByIdAndEstado(Long id, Boolean estado);
	
	@Query("select u from Productos u where u.estado = ?1")
	public List<Producto> findAllByEstado(Boolean estado);
 * 
 */



/*YT

import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long>{

}
*/

//Tambien se puede agregar con JPA REPOSITORY en vez de CrudRepository
/* 
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import academy.digitallab.store.product.entity.Category;

@Repository
public interface ProductoDao  extends JpaRepository<Producto, Long> {

    public List<Producto> findByCategory(Category category);
    
    @Query("select u from User u where u.emailAddress = ?1")
  	User findByEmailAddress(String emailAddress);
    
    
}
*/