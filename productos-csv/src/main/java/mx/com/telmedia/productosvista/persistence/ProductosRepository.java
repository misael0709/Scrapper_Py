package mx.com.telmedia.productosvista.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import mx.com.telmedia.productosvista.persistence.entities.Productos;

@Repository
public interface ProductosRepository extends PagingAndSortingRepository<Productos, Integer>{
	
	public static final String sql = "SELECT w.d_tipo,CONVERT(varchar,p.id_sku) as id_sku,p.d_nombre_sku,CONVERT(varchar,w.b_publicar) as b_publicar,CONVERT(varchar,w.b_destacar) as b_destacar,w.d_visibilidad,p.d_descripcion,p.d_caracteristicas, "
			+ "CONVERT(VARCHAR,w.f_fecha_inicio_rebaja,20) AS f_fecha_inicio_rebaja,CONVERT(VARCHAR,w.f_fecha_fin_rebaja,20) AS f_fecha_fin_rebaja,w.d_impuesto,CONVERT(varchar,w.b_en_catalogo) as b_en_catalogo,CONVERT(varchar,w.n_inventario_cant) as n_inventario_cant,CONVERT(varchar,w.n_cant_inventario_bajo) as n_cant_inventario_bajo, "
			+ "CONVERT(varchar,w.b_permitir_reservar) as b_permitir_reservar,CONVERT(varchar,w.b_venta_individual) as b_venta_individual,CONVERT(varchar,w.b_valoracion_clientes) as b_valoracion_clientes,CONVERT(varchar,w.n_precio_rebaja) as n_precio_rebaja,CONVERT(varchar,p.n_precio_publico) as n_precio_publico,w.d_categoria_woo, "
			+ "'' as d_url,'' as d_nombre_especificacion,'' as d_valor_especificacion "
			+ "FROM Productos p "
			+ "INNER JOIN woo w ON p.id_sku = w.id_sku ";
			//+ "WHERE p.id_sku = '18053'";//OR p.id_sku = '18053' OR p.id_sku = '18089' OR p.id_sku = '18092' OR p.id_sku = '18170' OR p.id_sku = '18122'";
	@Query(nativeQuery = true, value = sql)
	List<Productos>findProductos();
	
}
