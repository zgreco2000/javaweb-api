package ar.com.educacionit.services;

import ar.com.educacionit.app.domain.Producto;
import ar.com.educacionit.dao.ProductoDao;
import ar.com.educacionit.dao.exceptions.GenericException;
import ar.com.educacionit.dao.hibernate.impl.ProductoDAOHibernateImpl;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ProductoDao pdao = new ProductoDAOHibernateImpl();
        Producto producto;
		try {
			producto = pdao.getProducto("0001");
		        System.out.println(producto);
		    } catch (GenericException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

        
    }
}
