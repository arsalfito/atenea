/**
 * 
 */
package co.org.atenea.activos.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
@Getter
@Setter
public class ActivoFijoException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private int codigoError;
	
	public ActivoFijoException(String mensaje, int codError) {
		super(mensaje);
		codigoError = codError;
	}
	

}
