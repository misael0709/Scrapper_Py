package mx.com.telmedia.productosvista.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mx.com.telmedia.productosvista.persistence.entities.Especificaciones;


@Repository
public interface EspecificacionesRepo  extends JpaRepository <Especificaciones, String>{

	public static final String sql="select * from Especificaciones_productos where id_sku= :id_sku";
	
	@Query(nativeQuery = true, value = sql)
	List<Especificaciones>findBySku(@Param ("id_sku") String id_sku);
}
