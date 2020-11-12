package com.jcs.categorias.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcs.categorias.clientes.ProductoClienteRest;
import com.jcs.categorias.modelos.Producto;

@Service("serviceFeign")
public class ProductoServiceFeign implements IProductoServicio {

	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Producto> findAll() {
		return clienteFeign.listaProductos().getBody();
	}
	
}
