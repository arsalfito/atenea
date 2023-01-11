/**
 * 
 */
package co.org.atenea.activos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.org.atenea.activos.entidades.CaracteristicaActivo;

/**
 * @author arsal
 *
 */
public interface RepositorioCaracteristicaActivo extends JpaRepository<CaracteristicaActivo, Long> {
	
	CaracteristicaActivo findByActivoFijoId(Long id);
}
