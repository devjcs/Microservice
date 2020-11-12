package com.jcs.productos.modelo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcs.productos.modelo.dao.ProductoDao;
import com.jcs.productos.modelo.entity.Producto;

@Service
public class ProductoServicioImpl implements IProductoServicio {

	@Autowired
	private ProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		return (List<Producto>) productoDao.findAllByStatus(true);
	}

	@Override
	@Transactional(readOnly = true)
	public Producto findById(Long id) {
		Producto producto = productoDao.findByIdAndStatus(id, true);
		if (producto != null) {
			return producto;
		}
		return null;
	}

	@Override
	public Producto save(Producto producto) {
		producto.setFechaCreacion(new Date());
		return productoDao.save(producto);
	}

	@Override
	public Producto deleteById(Long id) {
		Producto producto = findById(id);
		if (producto != null && producto.getStock() == 0) {
			producto.setStatus(false);
			return productoDao.save(producto);
		}
		return null;
	}

}

/*
 * CURSO UDEMY
 * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 * <<<
 * 
 * @Service public class ProductoServicioImpl implements IProductoServicio{
 * 
 * @Autowired private ProductoDao productoDao;
 * 
 * @Override public List<Producto> findAll() { return (List<Producto>)
 * productoDao.findAll(); }
 * 
 * @Override public Producto findById(Long id) { return
 * productoDao.findById(id).orElse(null); }
 * 
 * @Override public Producto save(Producto producto) { return
 * productoDao.save(producto); }
 * 
 * @Override public void deleteById(Long id) { productoDao.deleteById(id); }
 * 
 * }
 * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 * >>>>>>>>>>>>>>>>>>
 */

/*
 * OTRA FORMA DE IMPLEMENTARLO MAS ELABORADA CURSO DE
 * YT<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
 * 
 * @Service
 * 
 * @RequiredArgsConstructor public class ProductServiceImpl implements
 * ProductService{
 * 
 * 
 * private final ProductRepository productRepository;
 * 
 * @Override public List<Product> listAllProduct() { return
 * productRepository.findAll(); }
 * 
 * @Override public Product getProduct(Long id) { return
 * productRepository.findById(id).orElse(null); }
 * 
 * @Override public Product createProduct(Product product) {
 * product.setStatus("CREATED"); product.setCreateAt(new Date());
 * 
 * return productRepository.save(product); }
 * 
 * @Override public Product updateProduct(Product product) { Product productDB =
 * getProduct(product.getId()); if (null == productDB){ return null; }
 * productDB.setName(product.getName());
 * productDB.setDescription(product.getDescription());
 * productDB.setCategory(product.getCategory());
 * productDB.setPrice(product.getPrice()); return
 * productRepository.save(productDB); }
 * 
 * @Override public Product deleteProduct(Long id) { Product productDB =
 * getProduct(id); if (null == productDB){ return null; }
 * productDB.setStatus("DELETED"); return productRepository.save(productDB); }
 * 
 * @Override public List<Product> findByCategory(Category category) { return
 * productRepository.findByCategory(category); }
 * 
 * @Override public Product updateStock(Long id, Double quantity) { Product
 * productDB = getProduct(id); if (null == productDB){ return null; } Double
 * stock = productDB.getStock() + quantity; productDB.setStock(stock); return
 * productRepository.save(productDB); } }
 * 
 * 
 * 
 * 
 */
