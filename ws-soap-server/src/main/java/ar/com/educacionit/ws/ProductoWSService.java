package ar.com.educacionit.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ar.com.educacionit.app.domain.Producto;


@WebService
public interface ProductoWSService {

	@WebMethod(operationName = "getProductoByCodigo")
	public Producto getProducto(@WebParam(name = "codigo")String codigo) throws InternalServerError;
	
	@WebMethod
}
