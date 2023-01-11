/**
 * 
 */
package co.org.atenea.activos.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
@Entity
@Getter
@Setter
public class Persona extends Responsable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "DOCUMENTO", unique = true)
	private String documento;

}
