package com.jcs.categorias.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jcs.categorias.modelos.Producto;


@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {
	
	@PostMapping("/productos")
	public ResponseEntity<Producto> nuevoProducto(@RequestBody Producto producto);
	
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>>listaProductos();

	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto>verProductoId(@PathVariable("id") Long id);
	
	@PutMapping("/productos")
	public ResponseEntity<Producto>actualizarProductoId(@RequestBody Producto producto);
	
	@DeleteMapping("/productos/{id}")
	public ResponseEntity<Producto>eliminarProductoId(@PathVariable("id") Long id);
	
}