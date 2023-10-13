package mx.com.telmedia.productosvista.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "imagenes")
public class Imagenes {
	
	@Column(name="id_sku")
	public int id_sku;
	@Id
	@Column(name="d_url")
	public String d_url;

	public int getId_sku() {
		return id_sku;
	}

	public void setId_sku(int id_sku) {
		this.id_sku = id_sku;
	}

	public String getD_url() {
		return d_url;
	}

	public void setD_url(String d_url) {
		this.d_url = d_url;
	}

	@Override
	public String toString() {
		return "Imagenes [id_sku="+id_sku+",d_url="+d_url+"]";
	}
}
