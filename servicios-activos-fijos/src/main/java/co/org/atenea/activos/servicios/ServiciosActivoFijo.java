/**
 * 
 */
package co.org.atenea.activos.servicios;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.org.atenea.activos.entidades.ActivoFijo;
import co.org.atenea.activos.entidades.CaracteristicaActivo;
import co.org.atenea.activos.exception.ActivoFijoException;
import co.org.atenea.activos.repositorios.RepositorioActivoFijo;
import co.org.atenea.activos.repositorios.RepositorioCaracteristicaActivo;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
@Service
@Transactional
public class ServiciosActivoFijo implements IServiciosActivoFijo {
	
	@Autowired
	private RepositorioActivoFijo repositorioActivoFijo;
	
	@Autowired
	private RepositorioCaracteristicaActivo repositorioCaracteristicaActivo; 
	

	@Override
	public ActivoFijo crear(ActivoFijo activoFijo) throws ActivoFijoException {
		
		if(activoFijo.getFechaCompra().after(activoFijo.getFechaBaja()))
			throw new ActivoFijoException("La fecha de compra no puede ser posterior a la fecha de baja.", 400);
		
		if(activoFijo.getTipoActivo()==null)
			throw new ActivoFijoException("No ha registrado el tipo de activo.", 400);
		
		CaracteristicaActivo caracteristica = activoFijo.getCaracteristicaActivo();
		ActivoFijo activoFijoDB = repositorioActivoFijo.save(activoFijo);
		
		caracteristica.setActivoFijo(activoFijoDB);
		repositorioCaracteristicaActivo.save(caracteristica);
		
		return repositorioActivoFijo.findById(activoFijoDB.getId()).get(); 
	}

	@Override
	public ActivoFijo actualizar(ActivoFijo activoFijo) throws ActivoFijoException{
		
		if(activoFijo==null || activoFijo.getId()==null) 
			throw new ActivoFijoException("El activo que desea actualizar es nulo.", 400);
		
		
		ActivoFijo activoFijoDB = repositorioActivoFijo.findById(activoFijo.getId()).orElse(null);
		if(activoFijoDB==null) 
			throw new ActivoFijoException("El activo que desea actualizar no está registrado en el sistema.", 404);
		if(activoFijo.getSerial()==null || activoFijo.getSerial().isEmpty())
			throw new ActivoFijoException("Favor ingrese el serial del activo fijo.", 400);
		if(activoFijo.getFechaBaja()==null || activoFijo.getSerial().isEmpty())
			throw new ActivoFijoException("Favor ingrese la fecha de baja del activo fijo.", 400);
		if(activoFijoDB.getFechaCompra().after(activoFijo.getFechaBaja()))
			throw new ActivoFijoException("La fecha de compra no puede ser posterior a la fecha de baja.", 400);
		
		activoFijoDB.setSerial(activoFijo.getSerial());
		activoFijoDB.setFechaBaja(activoFijo.getFechaBaja());
		
		return repositorioActivoFijo.save(activoFijoDB);
	}

	@Override
	public List<ActivoFijo> listarActivosFijos() throws ActivoFijoException{
		List<ActivoFijo> activos = repositorioActivoFijo.findAll();
		if(activos==null || activos.isEmpty()) 
			throw new ActivoFijoException("No hay activos registrados en el sistema.", 404);
		
		return activos;
	}

	@Override
	public List<ActivoFijo> buscarActivosFijosPorTipo(Integer idTipo) throws ActivoFijoException{
		if(idTipo==null)
			throw new ActivoFijoException("El id del tipo de activo es nulo.", 400);
		
		List<ActivoFijo> activos = repositorioActivoFijo.findActivoFijoByTipoActivoId(idTipo);
		if(activos==null || activos.isEmpty()) 
			throw new ActivoFijoException("No hay activos registrados en el sistema.", 404);
		
		return activos;
	}

	@Override
	public List<ActivoFijo> buscarActivosFijosPorFechaCompra(Date fechaCompra) throws ActivoFijoException{
		System.out.println("buscarActivosFijosPorFechaCompra");
		if(fechaCompra==null)
			throw new ActivoFijoException("La fecha de compra es nula.", 400);
		
		List<ActivoFijo> activos = repositorioActivoFijo.findByFechaCompra(fechaCompra);
		if(activos==null || activos.isEmpty()) 
			throw new ActivoFijoException("No hay activos registrados en el sistema.", 404);
		
		return activos;
	}

	@Override
	public ActivoFijo buscarActivosFijosPorSerial(String serial) throws ActivoFijoException{
		if(serial==null || serial.isEmpty())
			throw new ActivoFijoException("El número serial del activo fijo es nulo.", 400);
		
		ActivoFijo activo = repositorioActivoFijo.findBySerial(serial);
		if(activo==null) {
			throw new ActivoFijoException("El activo fijo que desea consultar no está registrado en el sistema.", 404);
		}
		
		return activo;
	}

	@Override
	public ActivoFijo buscarActivosFijosPorId(Long id) throws ActivoFijoException{
		ActivoFijo activoFijoDB = repositorioActivoFijo.findById(id).orElse(null); 
		if(activoFijoDB==null) {
			throw new ActivoFijoException("El activo fijo que desea consultar no está registrado en el sistema.", 404);
		}
		return activoFijoDB;
	}

}
