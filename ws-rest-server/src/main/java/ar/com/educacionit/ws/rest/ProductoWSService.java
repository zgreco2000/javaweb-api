package ar.com.educacionit.ws.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ar.com.educacionit.app.domain.Producto;
import ar.com.educacionit.services.ProductoService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ProductoServiceImpl;

@Path("productos")
public class ProductoWSService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllProductos() {
		
		//acceso a la capa core
		
		ProductoService productoService = new ProductoServiceImpl();
		
		try {
			List<Producto> productos = productoService.findProductos();
			return Response.ok(productos).build();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			
		}
						
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProducto(Producto producto) {
		
		//capa de Servcio
		
		ProductoService productoService = new ProductoServiceImpl();
		
		try {
			productoService.createProducto(producto);
			return Response.status(Status.CREATED).entity(producto).build();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			return Response.status(Status.BAD_REQUEST).entity(producto).build();
		}
		
		
	}
	
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modificaProducto(Producto producto) {
		
		//capa de Servcio
		
		ProductoService productoService = new ProductoServiceImpl();
		
		try {
			productoService.updateProducto(producto);
			return Response.status(Status.ACCEPTED).entity(producto).build();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			return Response.status(Status.BAD_REQUEST).entity(producto).build();
		}
		
}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response eliminaProducto(Producto producto) {
		
		//capa de Servcio
		
		ProductoService productoService = new ProductoServiceImpl();
		
		try {
			productoService.eliminarProducto(producto.getCodigo());
			return Response.status(Status.ACCEPTED).entity(producto).build();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			return Response.status(Status.BAD_REQUEST).entity(producto).build();
		}
		
}

	
	@GET
	@Path("/{codigoProducto}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductoById(
			@PathParam("codigoProducto")
			String codigo
			) {
		
		//acceso a la capa core
		
		ProductoService productoService = new ProductoServiceImpl();
		
		try {
			Producto productos = productoService.getProducto(codigo);
			return Response.ok(productos).build();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
			
		}
						
	}
	
	
	
}