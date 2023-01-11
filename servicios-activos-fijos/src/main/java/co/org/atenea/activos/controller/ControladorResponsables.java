/**
 * 
 */
package co.org.atenea.activos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.org.atenea.activos.entidades.Area;
import co.org.atenea.activos.entidades.Persona;
import co.org.atenea.activos.exception.ActivoFijoException;
import co.org.atenea.activos.servicios.IServiciosResponsables;

/**
 * @author arsal
 *
 */
@RequestMapping("/responsable")
@RestController
public class ControladorResponsables {
	
	@Autowired
	private IServiciosResponsables serviciosResponsables;
	
	@PostMapping("/crearPersona")
	public ResponseEntity<Persona>  crearPersona(@RequestBody Persona persona) {
		HttpHeaders headers = new HttpHeaders();
		try {
			Persona result = serviciosResponsables.crearPersona(persona);			
			headers.add("mensaje", "El responsable fue creado satisfactoriamente.");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(result);
		} catch (ActivoFijoException e) {					
			headers.add("MensajeError", e.getMessage());
			return ResponseEntity.status(e.getCodigoError()).headers(headers).body(null);
		}
	}
	
	@GetMapping("/listarPersonas")
	public ResponseEntity<List<Persona>> listarPersonas() {
		HttpHeaders headers = new HttpHeaders();
		try {
			List<Persona> result = serviciosResponsables.listarPersonas();			
			headers.add("mensaje", "Se retorna la lista de personas registradas.");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(result);			
		} catch (ActivoFijoException e) {					
			headers.add("MensajeError", e.getMessage());
			return ResponseEntity.status(e.getCodigoError()).headers(headers).body(null);
		}	
	}
	
	@PostMapping("/crearArea")
	public ResponseEntity<Area>  crearArea(@RequestBody Area area) {
		HttpHeaders headers = new HttpHeaders();
		try {
			Area result = serviciosResponsables.crearArea(area);			
			headers.add("mensaje", "El responsable fue creado satisfactoriamente.");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(result);
		} catch (ActivoFijoException e) {					
			headers.add("MensajeError", e.getMessage());
			return ResponseEntity.status(e.getCodigoError()).headers(headers).body(null);
		}
	}
	
	@GetMapping("/listarAreas")
	public ResponseEntity<List<Area>> listarAreas() {
		HttpHeaders headers = new HttpHeaders();
		try {
			List<Area> result = serviciosResponsables.listarAreas();			
			headers.add("mensaje", "Se retorna la lista de áreas registradas.");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(result);
		} catch (ActivoFijoException e) {					
			headers.add("MensajeError", e.getMessage());
			return ResponseEntity.status(e.getCodigoError()).headers(headers).body(null);
		}	
	}

}
