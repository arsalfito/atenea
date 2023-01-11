/**
 * 
 */
package co.org.atenea.activos.servicios;

import java.util.List;

import co.org.atenea.activos.entidades.Area;
import co.org.atenea.activos.entidades.Persona;
import co.org.atenea.activos.exception.ActivoFijoException;

/**
 * @author arsal
 *
 */
public interface IServiciosResponsables {
	
	public Persona crearPersona(Persona persona) throws ActivoFijoException;
	public List<Persona> listarPersonas() throws ActivoFijoException;
	public Area crearArea(Area area) throws ActivoFijoException;
	public List<Area> listarAreas() throws ActivoFijoException;

}
