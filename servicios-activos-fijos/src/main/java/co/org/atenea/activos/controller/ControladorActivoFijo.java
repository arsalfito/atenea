/**
 * 
 */
package co.org.atenea.activos.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.org.atenea.activos.entidades.ActivoFijo;
import co.org.atenea.activos.exception.ActivoFijoException;
import co.org.atenea.activos.servicios.IServiciosActivoFijo;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
@RequestMapping("/activo")
@RestController
public class ControladorActivoFijo {

	@Autowired
	private IServiciosActivoFijo serviciosActivoFijo;
	
	
	@PostMapping("/crearActivoFijo")
	public ResponseEntity<ActivoFijo>  crearActivoFijo(@RequestBody ActivoFijo activoFijo) {
		HttpHeaders headers = new HttpHeaders();
		try {
			ActivoFijo result = serviciosActivoFijo.crear(activoFijo);			
			headers.add("mensaje", "El activo fijo fue creado satisfactoriamente.");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(result);
		} catch (ActivoFijoException e) {					
			headers.add("MensajeError", e.getMessage());
			return ResponseEntity.status(e.getCodigoError()).headers(headers).body(null);
		}
	}
	
	@PostMapping("/actualizarActivoFijo")
	public ResponseEntity<ActivoFijo> actualizar(@RequestBody ActivoFijo activoFijo) throws ActivoFijoException{
		HttpHeaders headers = new HttpHeaders();
		try {
			ActivoFijo result = serviciosActivoFijo.actualizar(activoFijo);			
			headers.add("mensaje", "El activo fijo fue actualizado satisfactoriamente.");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(result);
		} catch (ActivoFijoException e) {					
			headers.add("MensajeError", e.getMessage());
			return ResponseEntity.status(e.getCodigoError()).headers(headers).body(null);
		}		
	}
	
	@GetMapping("/findActivoFijoById")
	public ResponseEntity<ActivoFijo> findActivoFijoById(@RequestParam Long id) {
		System.out.println("findActivoFijoById");
		HttpHeaders headers = new HttpHeaders();
		ActivoFijo result;
		try {
			result = serviciosActivoFijo.buscarActivosFijosPorId(id);	
			headers.add("mensaje", "Se retorna el activo fijo registrado.");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(result);
		} catch (ActivoFijoException e) {
			headers.add("MensajeError", e.getMessage());
			return ResponseEntity.status(e.getCodigoError()).headers(headers).body(null);
		}
	}
	
	@GetMapping("/listarActivosFijos")
	public ResponseEntity<List<ActivoFijo>> listarActivosFijos() {
		HttpHeaders headers = new HttpHeaders();
		try {
			List<ActivoFijo> result = serviciosActivoFijo.listarActivosFijos();			
			headers.add("mensaje", "Se retorna la lista de activos fijos registrados.");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(result);
		} catch (ActivoFijoException e) {					
			headers.add("MensajeError", e.getMessage());
			return ResponseEntity.status(e.getCodigoError()).headers(headers).body(null);
		}	
	}
	
	@GetMapping("/buscarActivosFijosPorTipo")
	public ResponseEntity<List<ActivoFijo>> buscarActivosFijosPorTipo(@RequestParam Integer idTipo) throws ActivoFijoException{
		HttpHeaders headers = new HttpHeaders();
		try {
			List<ActivoFijo> result = serviciosActivoFijo.buscarActivosFijosPorTipo(idTipo);			
			headers.add("mensaje", "Se retorna la lista de activos fijos registrados.");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(result);
		} catch (ActivoFijoException e) {			
			headers.add("MensajeError", e.getMessage());
			return ResponseEntity.status(e.getCodigoError()).headers(headers).body(null);
		}	
	}
	
	@GetMapping("/buscarActivosFijosPorFechaCompra")
	public ResponseEntity<List<ActivoFijo>> buscarActivosFijosPorFechaCompra(@RequestParam String fechaCompra) throws ActivoFijoException{
		HttpHeaders headers = new HttpHeaders();
		try {                                                
			Date fc = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(fechaCompra);  
			List<ActivoFijo> result = serviciosActivoFijo.buscarActivosFijosPorFechaCompra(fc);			
			headers.add("mensaje", "Se retorna la lista de activos fijos registrados.");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(result);
		} catch (ActivoFijoException e) {			
			headers.add("MensajeError", e.getMessage());
			return ResponseEntity.status(e.getCodigoError()).headers(headers).body(null);
		} catch (ParseException e) {
			headers.add("MensajeError", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(null);
		}	
	}
	
	@GetMapping("/buscarActivosFijosPorSerial")
	public ResponseEntity<ActivoFijo> buscarActivosFijosPorSerial(@RequestParam String serial) throws ActivoFijoException{
		HttpHeaders headers = new HttpHeaders();
		ActivoFijo result;
		try {
			result = serviciosActivoFijo.buscarActivosFijosPorSerial(serial);	
			headers.add("mensaje", "Se retorna el activo fijo registrado.");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(result);
		} catch (ActivoFijoException e) {
			headers.add("MensajeError", e.getMessage());
			return ResponseEntity.status(e.getCodigoError()).headers(headers).body(null);
		}
	}
}
