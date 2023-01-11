/**
 * 
 */
package co.org.atenea.activos.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.org.atenea.activos.entidades.ActivoFijo;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
public interface RepositorioActivoFijo extends JpaRepository<ActivoFijo, Long> {
	
	//Buscar por tipo de activo
	@Query("SELECT af FROM ActivoFijo af WHERE af.tipoActivo.id = :idTipoActivo")
	List<ActivoFijo> findActivoFijoByTipoActivoId(Integer idTipoActivo);
	
	//Buscar por fecha de compra
	@Query("SELECT af FROM ActivoFijo af WHERE af.fechaCompra <= :fechaCompra")
	List<ActivoFijo> findByFechaCompra(Date fechaCompra);
	
	//Buscar por serial
	ActivoFijo findBySerial(String serial);
}
