/**
 * 
 */
package co.org.atenea.activos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.org.atenea.activos.entidades.Responsable;

/**
 * @author arsal
 *
 */
public interface RepositorioResponsables<T extends Responsable> extends JpaRepository<T,Long>{ 

	@Query("select p from Responsable p where p.TIPO_RESPONSABLE = :myDType")
	List<T> getResponsables(String myDType);
}
