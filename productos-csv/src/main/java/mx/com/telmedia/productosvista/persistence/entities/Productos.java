package mx.com.telmedia.productosvista.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Productos")
public class Productos {
	
	@Column(name = "d_tipo")
	String d_tipo;
	@Id
	@Column(name = "id_sku")
	String id_sku;
	@Column(name = "d_nombre_sku")
	String d_nombre_sku;
	@Column(name = "b_publicar")
	String b_publicar;
	@Column(name = "b_destacar")
	String b_destacar;
	@Column(name = "d_visibilidad")
	String d_visibilidad;
	@Column(name = "d_descripcion")
	String d_descripcion;
	@Column(name = "d_caracteristicas")
	String d_caracteristicas;
	@Column(name = "f_fecha_inicio_rebaja")
	String f_fecha_inicio_rebaja;
	@Column(name = "f_fecha_fin_rebaja")
	String f_fecha_fin_rebaja;
	@Column(name = "d_impuesto")
	String d_impuesto;
	@Column(name = "b_en_catalogo")
	String b_en_catalogo;
	@Column(name = "n_inventario_cant")
	String n_inventario_cant;
	@Column(name = "n_cant_inventario_bajo")
	String n_cant_inventario_bajo;
	@Column(name = "b_permitir_reservar")
	String b_permitir_reservar;
	@Column(name = "b_venta_individual")
	String b_venta_individual;
	@Column(name = "b_valoracion_clientes")
	String b_valoracion_clientes;
	@Column(name = "n_precio_rebaja")
	String n_precio_rebaja;
	@Column(name = "n_precio_publico")
	String n_precio_publico;
	@Column(name = "d_categoria_woo")
	String d_categoria_principal;
	@Column(name = "d_nombre_especificacion")
	String d_nombre_especificacion;
	@Column(name = "d_valor_especificacion")
	String d_valor_especificacion;
	@Column(name = "d_url")
	String d_url;

	public String getD_tipo() {
		return d_tipo;
	}

	public void setD_tipo(String d_tipo) {
		this.d_tipo = d_tipo;
	}

	public String getId_sku() {
		return id_sku;
	}

	public void setId_sku(String id_sku) {
		this.id_sku = id_sku;
	}

	public String getD_nombre_sku() {
		return d_nombre_sku;
	}

	public void setD_nombre_sku(String d_nombre_sku) {
		this.d_nombre_sku = d_nombre_sku;
	}

	public String getB_publicar() {
		return b_publicar;
	}

	public void setB_publicar(String b_publicar) {
		this.b_publicar = b_publicar;
	}

	public String getB_destacar() {
		return b_destacar;
	}

	public void setB_destacar(String b_destacar) {
		this.b_destacar = b_destacar;
	}

	public String getD_visibilidad() {
		return d_visibilidad;
	}

	public void setD_visibilidad(String d_visibilidad) {
		this.d_visibilidad = d_visibilidad;
	}

	public String getD_descripcion() {
		return d_descripcion;
	}

	public void setD_descripcion(String d_descripcion) {
		this.d_descripcion = d_descripcion;
	}

	public String getD_caracteristicas() {
		return d_caracteristicas;
	}

	public void setD_caracteristicas(String d_caracteristicas) {
		this.d_caracteristicas = d_caracteristicas;
	}

	public String getF_fecha_inicio_rebaja() {
		return f_fecha_inicio_rebaja;
	}

	public void setF_fecha_inicio_rebaja(String f_fecha_inicio_rebaja) {
		this.f_fecha_inicio_rebaja = f_fecha_inicio_rebaja;
	}

	public String getF_fecha_fin_rebaja() {
		return f_fecha_fin_rebaja;
	}

	public void setF_fecha_fin_rebaja(String f_fecha_fin_rebaja) {
		this.f_fecha_fin_rebaja = f_fecha_fin_rebaja;
	}

	public String getD_impuesto() {
		return d_impuesto;
	}

	public void setD_impuesto(String d_impuesto) {
		this.d_impuesto = d_impuesto;
	}

	public String getB_en_catalogo() {
		return b_en_catalogo;
	}

	public void setB_en_catalogo(String b_en_catalogo) {
		this.b_en_catalogo = b_en_catalogo;
	}

	public String getN_inventario_cant() {
		return n_inventario_cant;
	}

	public void setN_inventario_cant(String n_inventario_cant) {
		this.n_inventario_cant = n_inventario_cant;
	}

	public String getN_cant_inventario_bajo() {
		return n_cant_inventario_bajo;
	}

	public void setN_cant_inventario_bajo(String n_cant_inventario_bajo) {
		this.n_cant_inventario_bajo = n_cant_inventario_bajo;
	}

	public String getB_permitir_reservar() {
		return b_permitir_reservar;
	}

	public void setB_permitir_reservar(String b_permitir_reservar) {
		this.b_permitir_reservar = b_permitir_reservar;
	}

	public String getB_venta_individual() {
		return b_venta_individual;
	}

	public void setB_venta_individual(String b_venta_individual) {
		this.b_venta_individual = b_venta_individual;
	}

	public String getB_valoracion_clientes() {
		return b_valoracion_clientes;
	}

	public void setB_valoracion_clientes(String b_valoracion_clientes) {
		this.b_valoracion_clientes = b_valoracion_clientes;
	}

	public String getN_precio_rebaja() {
		return n_precio_rebaja;
	}

	public void setN_precio_rebaja(String n_precio_rebaja) {
		this.n_precio_rebaja = n_precio_rebaja;
	}

	public String getN_precio_publico() {
		return n_precio_publico;
	}

	public void setN_precio_publico(String n_precio_publico) {
		this.n_precio_publico = n_precio_publico;
	}

	public String getD_categoria_principal() {
		return d_categoria_principal;
	}

	public void setD_categoria_principal(String d_categoria_principal) {
		this.d_categoria_principal = d_categoria_principal;
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

	public String getD_url() {
		return d_url;
	}

	public void setD_url(String d_url) {
		this.d_url = d_url;
	}

	@Override
	public String toString() {
		return "Productos [d_tipo=" + d_tipo + ", id_sku=" + id_sku + ", d_nombre_sku=" + d_nombre_sku + ", b_publicar="
				+ b_publicar + ", b_destacar=" + b_destacar + ", d_visibilidad=" + d_visibilidad + ", d_descripcion="
				+ d_descripcion + ", d_caracteristicas=" + d_caracteristicas + ", f_fecha_inicio_rebaja="
				+ f_fecha_inicio_rebaja + ", f_fecha_fin_rebaja=" + f_fecha_fin_rebaja + ", d_impuesto=" + d_impuesto
				+ ", b_en_catalogo=" + b_en_catalogo + ", n_inventario_cant=" + n_inventario_cant
				+ ", n_cant_inventario_bajo=" + n_cant_inventario_bajo + ", b_permitir_reservar=" + b_permitir_reservar
				+ ", b_venta_individual=" + b_venta_individual + ", b_valoracion_clientes=" + b_valoracion_clientes
				+ ", n_precio_rebaja=" + n_precio_rebaja + ", n_precio_publico=" + n_precio_publico
				+ ", d_categoria_principal=" + d_categoria_principal + ", d_nombre_especificacion="
				+ d_nombre_especificacion + ", d_valor_especificacion=" + d_valor_especificacion + ", d_url=" + d_url
				+ "]";
	}

	public String[] toArray() {
		String[] p = new String[35];
//		String precio;
//		if (getN_precio_publico() != null) {
//			precio = getN_precio_publico().toString();
//		} else {
//			precio = "";
//		}
		p[0] = ""; // ID
		p[1] = d_tipo;
		p[2] = id_sku;
		p[3] = d_nombre_sku;
		p[4] = b_publicar;// publicado;
		p[5] = b_destacar;// destacado;
		p[6] = d_visibilidad;
		p[7] = d_descripcion;
		p[8] = d_caracteristicas;
		p[9] = f_fecha_inicio_rebaja;// fechaini;
		p[10] = f_fecha_fin_rebaja;// fechafin;
		p[11] = d_impuesto;// d_impuesto;
		p[12] = ""; // clase de impuesto
		p[13] = b_en_catalogo;// eninv;
		p[14] = n_inventario_cant;
		p[15] = n_cant_inventario_bajo;
		p[16] = b_permitir_reservar;
		p[17] = b_venta_individual;// vIndiv;
		p[18] = ""; // peso
		p[19] = ""; // longitud
		p[20] = ""; // ancho
		p[21] = ""; // altura
		p[22] = b_valoracion_clientes;// valoracion;
		p[23] = ""; // nota de compras
		p[24] = n_precio_rebaja;
		p[25] = n_precio_publico;
		p[26] = d_categoria_principal;
		p[27] = ""; // etiquetas
		p[28] = ""; // clase de envio
		p[29] = d_url;
		p[30] = "";// posicion
		p[31] = d_nombre_especificacion;
		p[32] = d_valor_especificacion;
		p[33] = "1"; // Atributo visible
		p[34] = "1"; // Atributo global
		return p;
	}

}
