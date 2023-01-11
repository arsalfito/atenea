package co.org.atenea.activos.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.org.atenea.activos.entidades.Area;
import co.org.atenea.activos.entidades.Persona;
import co.org.atenea.activos.exception.ActivoFijoException;
import co.org.atenea.activos.repositorios.RepositorioResponsables;

@Service
public class ServiciosResponsables implements IServiciosResponsables {

	@Autowired
	private RepositorioResponsables<Persona> repositorioPersonas;
	
	@Autowired
	private RepositorioResponsables<Area> repositorioAreas;
	
	
	@Override
	public Persona crearPersona(Persona persona) throws ActivoFijoException {
		return repositorioPersonas.save(persona);
	}

	@Override
	public List<Persona> listarPersonas() throws ActivoFijoException {		
		return repositorioPersonas.getResponsables("Persona");
	}

	@Override
	public Area crearArea(Area area) throws ActivoFijoException {
		return repositorioAreas.save(area);
	}

	@Override
	public List<Area> listarAreas() throws ActivoFijoException {
		return repositorioAreas.getResponsables("Area");
	}

}
