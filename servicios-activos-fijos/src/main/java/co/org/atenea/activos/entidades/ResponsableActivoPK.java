/**
 * 
 */
package co.org.atenea.activos.entidades;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alfonso Rodriguez Suarez
 *
 */
@Embeddable
@Getter
@Setter
public class ResponsableActivoPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManyToOne( fetch = FetchType.LAZY )
	private Responsable responsable;
	
	@ManyToOne( fetch = FetchType.LAZY )
	private ActivoFijo activoFijo;

}
