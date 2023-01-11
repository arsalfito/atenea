/**
 * 
 */
package co.org.atenea.activos.servicios;

import java.util.Date;
import java.util.List;

import co.org.atenea.activos.entidades.ActivoFijo;
import co.org.atenea.activos.exception.ActivoFijoException;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
public interface IServiciosActivoFijo {
	
	public ActivoFijo crear(ActivoFijo activoFijo) throws ActivoFijoException;
	public ActivoFijo actualizar(ActivoFijo activoFijo) throws ActivoFijoException;
	public List<ActivoFijo> listarActivosFijos() throws ActivoFijoException;
	public ActivoFijo buscarActivosFijosPorId(Long id) throws ActivoFijoException;
	public List<ActivoFijo> buscarActivosFijosPorTipo(Integer idTipo) throws ActivoFijoException;
	public List<ActivoFijo> buscarActivosFijosPorFechaCompra(Date fechaCompra) throws ActivoFijoException;
	public ActivoFijo buscarActivosFijosPorSerial(String serial) throws ActivoFijoException;

}
