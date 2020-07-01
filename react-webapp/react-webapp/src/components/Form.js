import React from 'react';
	class Form extends React.Component {
	

	    nuevoProducto = async (e) => {
	        e.preventDefault();
	        let jsonObject= {
	            codigo: e.target.elements.codigo.value,
	            nombre: e.target.elements.nombre.value,
	            precio: e.target.elements.precio.value
	        }
	        console.log(jsonObject);
	

	        // create a new XMLHttpRequest
	        var xhr = new XMLHttpRequest();
	        xhr.open('POST', 'http://localhost:8080/ws-rest-server/api/productos');
	        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	        xhr.send(JSON.stringify(jsonObject));
	/*
	        const response = await axios.post(
	            'http://localhost:8080/app-ws-rest/api/productos',
	            jsonObject,
	            { headers: { 'Content-Type': 'application/json' } }
	          );*/
	

	      }
	

	    render() {
	        return (
	            <div className="row mt-3">
	                <div className="col-6">
	                    <form onSubmit={this.props.getWeather}>
	                        <div className="form-group">
	                            <label htmlFor="bnombre">Nombre</label>
	                            <input type="text" className="form-control" name="bnombre" id="bnombre"></input>
	                        </div>
	                        <button className="btn btn-primary">Get Productos</button>
	                    </form>
	                </div>
	                <div className="col-6">
	                    <form onSubmit={this.nuevoProducto}>                
	                        <div className="form-group">
	                            <label htmlFor="eid">Codigo</label>
	                            <input type="number" className="form-control" name="codigo" id="eid"></input>
	                        </div>
	                        <div className="form-group">
	                            <label htmlFor="epassword">Nombre</label>
	                            <input type="text" className="form-control" id="descripcion" name="nombre"></input>
	                        </div>
	                        <div className="form-group">
	                            <label htmlFor="eprecio">Precio</label>
	                            <input type="text" className="form-control" name="precio" id="eprecio"></input>
	                        </div>
	                        <button className="btn btn-primary">Grabar</button>
	                    </form>
	                </div>
	            </div>
	        );
	    }
	}
	

	export default Form;