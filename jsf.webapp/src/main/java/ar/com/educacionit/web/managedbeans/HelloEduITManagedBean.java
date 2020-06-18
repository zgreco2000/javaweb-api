package ar.com.educacionit.web.managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name= "helloEduITManagedBean", eager = true)
public class HelloEduITManagedBean {

	
public HelloEduITManagedBean() {
}	

public String getMessage() {
			return ("Hola Primer Prueba exitosa de JSF");
		}
		
	
	
	
}
