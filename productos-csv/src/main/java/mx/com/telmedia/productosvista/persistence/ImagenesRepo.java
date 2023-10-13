package mx.com.telmedia.productosvista.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mx.com.telmedia.productosvista.persistence.entities.Imagenes;

public interface ImagenesRepo extends JpaRepository<Imagenes, String>{
	public static final String sql= "select * from imagenes where id_sku= :id_sku";
	@Query(nativeQuery = true, value = sql)
	List<Imagenes> findById_sku(@Param ("id_sku") String id_sku);

}
