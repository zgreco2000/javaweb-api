package ar.com.educacionit.app.ws.meli.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import ar.com.educacionit.app.domain.Producto;

public class ProductoResourceClient {
	
	public static void main(String[] args) {
		
		//Client
		Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFeature.class));
		
		//WebTarget
		WebTarget webTarget = client.target("http://localhost:8080/ws-rest-server/api").path("productos");
		
		//Invocation.Builder
		Invocation.Builder iv = webTarget.request(MediaType.APPLICATION_JSON);
		
		//GET PUT PUT
		Response response = iv.get();
		
		//Producto producto = response.readEntity(Producto.class);
		
		GenericType<List<Producto>> entity = new GenericType<List<Producto>>() {
		};
		
		List<Producto> productos = response.readEntity(entity);
		
		for(Producto p : productos) {
			System.out.println(p);
		}
	}
	

}
