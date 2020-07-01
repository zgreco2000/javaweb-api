package ar.com.educacionit.services.impl;

import java.util.List;

import ar.com.educacionit.app.domain.Producto;
import ar.com.educacionit.app.domain.TipoProducto;
import ar.com.educacionit.dao.ProductoDao;
import ar.com.educacionit.dao.exceptions.DuplicateException;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.hibernate.impl.ProductoDAOHibernateImpl;
import ar.com.educacionit.services.ProductoService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class ProductoServiceImpl implements ProductoService {

	private ProductoDao productoDao;
	
	public ProductoServiceImpl() {
		this.productoDao = new ProductoDAOHibernateImpl();
		//this.productoDao = new ProductoDAOJDBCImpl();
	}
	
	@Override
	public Producto getProducto(String codigo) throws ServiceException {
		try {
			return this.productoDao.getProducto(codigo);
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServiceException("No se ha podido obtener el producto. Codigo="+codigo, e);
		}
	}

	@Override
	public List<Producto> findProductos() throws ServiceException {
		try {
			return this.productoDao.findProductos();
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServiceException("No se ha podido obtener el lisado de productos",e);
		}
	}

	@Override
	public Producto createProducto(Producto producto) throws ServiceException {
		try {
			return this.productoDao.createProducto(producto);
		} catch (DuplicateException e) {
			e.printStackTrace();
			throw new ServiceException("Producto existente ["+e.getMessage()+"]", e);
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServiceException("Error inesperado creando el producto ["+e.getMessage()+"]", e);
		}
	}
	
	@Override
	public Producto updateProducto(Producto producto) throws ServiceException {
		try {
			return this.productoDao.updateProducto(producto);
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServiceException("Error inesperado creando el producto ["+e.getMessage()+"]", e);
		}
	}

	@Override
	public Producto eliminarProducto(String codigoProducto) throws ServiceException {
		try {
			return this.productoDao.deleteProducto(codigoProducto);
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServiceException("Error inesperado creando el producto ["+e.getMessage()+"]", e);
		}
	}

	@Override
	public List<TipoProducto> findTipoProductos() throws ServiceException {
		try {
			return this.productoDao.findTipoProductos();
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServiceException("Error inesperado consultando tipo de productos["+e.getMessage()+"]", e);
		}
	}
	
	@Override
	public List<Producto> findProductosByDescripcion(String desripcion) throws ServiceException {
		try {
			return this.productoDao.findByDescripcion(desripcion);
		} catch (GenericException e) {
			e.printStackTrace();
			throw new ServiceException("Error inesperado consultando tipo de productos["+e.getMessage()+"]", e);
		}
	}
}