package mx.com.telmedia.productosvista.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Especificaciones_productos")
public class Especificaciones {
	@Id
	@Column(name="id_seq")
	int id_seq;
	@Column(name="id_sku")
	int id_sku;
	@Column(name="d_nombre_especificacion")
	String d_nombre_especificacion;
	@Column(name="d_valor_especificacion")
	String d_valor_especificacion; 
	

public int getId_sku() {
	return id_sku;
}

public void setId_sku(int id_sku) {
	this.id_sku = id_sku;
}

public String getD_nombre_especificacion() {
	return d_nombre_especificacion;
}

public void setD_nombre_especificacion(String d_nombre_especificacion) {
	this.d_nombre_especificacion = d_nombre_especificacion;
}

public String getD_valor_especificacion() {
	return d_valor_especificacion;
}

public void setD_valor_especificacion(String d_valor_especificacion) {
	this.d_valor_especificacion = d_valor_especificacion;
}

public int getId_seq() {
	return id_seq;
}

public void setId_seq(int id_seq) {
	this.id_seq = id_seq;
}

@Override
public String toString() {
	return "Especificaciones [id_seq=" + id_seq + ", id_sku=" + id_sku + ", d_nombre_especificacion="
			+ d_nombre_especificacion + ", d_valor_especificacion=" + d_valor_especificacion + "]";
}
}
