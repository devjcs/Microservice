package com.jcs.categorias.modelo.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcs.categorias.modelo.dao.CategoriaDao;
import com.jcs.categorias.modelo.entity.Categoria;
import com.jcs.categorias.modelos.Producto;

@Service
public class CategoriaServicioImpl  implements ICategoriaServicio{

	@Autowired
	private CategoriaDao categoriaDao;
	
	@Autowired
	private ProductoServiceFeign productoServiceFeing;
	
	@Override
	public List<Categoria> findAll() {
		return (List<Categoria>) categoriaDao.findAllByStatus(true);
	}

	@Override
	public Categoria findById(Long id) {
		Categoria categoria = categoriaDao.findByIdAndStatus(id, true);
		if (categoria != null) {
			return categoria;
		}
		return null;
	}

	@Override
	public Categoria save(Categoria categoria) {
		categoria.setFechaCreacion(new Date());
		return categoriaDao.save(categoria);
	}

	@Override
	public Categoria deleteById(Long id) {
		Categoria categoria = findById(id);
		List<Producto> productos = productoServiceFeing.findAll();
		int activos = 0;
		if (productos != null) {
			for (Producto p : productos) {
				if (p.getStatus() == true) {
					activos++;
				}
			}
		}
		if (categoria != null && activos == 0) {
			categoria.setStatus(false);
			return categoriaDao.save(categoria);
		}
		return null;
	}

}
