package mx.com.telmedia.productosvista.response;

import java.util.List;

import mx.com.telmedia.productosvista.persistence.entities.Productos;

public class ProductosResponse extends Payload {
	List <Productos> productos;
	
	public List<Productos> getProductos() {
		return productos;
	}
	
	public void setProductos(List<Productos> productos) {
		this.productos = productos;
	}


}
